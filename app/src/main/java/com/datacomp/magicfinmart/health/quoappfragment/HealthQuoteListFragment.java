package com.datacomp.magicfinmart.health.quoappfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.HealthActivityTabsPagerAdapter;
import com.datacomp.magicfinmart.health.healthquotetabs.HealthQuoteBottomTabsActivity;
import com.datacomp.magicfinmart.utility.RecyclerItemClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.health.HealthController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthDeleteResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthQuoteListFragment extends BaseFragment implements View.OnClickListener, IResponseSubcriber {

    public static final String HEALTH_INPUT_FRAGMENT = "input_fragment_bottom";


    FloatingActionButton btnAddQuote;
    RecyclerView rvHealthQuoteList;
    HealthQuoteAdapter healthQuoteAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<HealthQuote> mQuoteList;
    HealthQuote removeQuoteEntity;
    TextView tvAdd, tvSearch;
    EditText etSearch;
    ImageView ivSearch;


    public HealthQuoteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_health_quote, container, false);
        initView(view);
        setListener();
        setTextWatcher();
        mQuoteList = new ArrayList<>();
        if (getArguments().getParcelableArrayList(HealthActivityTabsPagerAdapter.HEALTH_QUOTE_LIST) != null) {
            mQuoteList = getArguments().getParcelableArrayList(HealthActivityTabsPagerAdapter.HEALTH_QUOTE_LIST);
        }
        healthQuoteAdapter = new HealthQuoteAdapter(HealthQuoteListFragment.this, mQuoteList);
        rvHealthQuoteList.setAdapter(healthQuoteAdapter);

        //recyclerview item click listener
        //rvHealthQuoteList.addOnItemTouchListener(new RecyclerItemClickListener(rvHealthQuoteList, onItemClickListener));
        return view;
    }

    /*
        Redirect to health quote to show all quote
     */
    public void quoteItemClick(HealthQuote healthQuote) {
        Intent intent = new Intent(getActivity(), HealthQuoteBottomTabsActivity.class);
        intent.putExtra(HEALTH_INPUT_FRAGMENT, healthQuote);
        startActivity(intent);
    }

    private void initView(View view) {
        ivSearch = (ImageView) view.findViewById(R.id.ivSearch);
        tvAdd = (TextView) view.findViewById(R.id.tvAdd);
        tvSearch = (TextView) view.findViewById(R.id.tvSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        etSearch.setVisibility(View.INVISIBLE);
        btnAddQuote = (FloatingActionButton) view.findViewById(R.id.fbAddHealthQuote);
        rvHealthQuoteList = (RecyclerView) view.findViewById(R.id.rvHealthQuoteList);
        rvHealthQuoteList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvHealthQuoteList.setLayoutManager(layoutManager);
        btnAddQuote.setOnClickListener(this);

    }

    private void setListener() {
        ivSearch.setOnClickListener(this);
        tvAdd.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    private void setTextWatcher() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                healthQuoteAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void removeQuote(HealthQuote entity) {

        removeQuoteEntity = entity;
        showDialog("Please wait,Removing quote..");
        new HealthController(getContext()).deleteQuote("" + entity.getHealthRequestId(),
                this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tvAdd:
            case R.id.fbAddHealthQuote:
                startActivity(new Intent(getActivity(), HealthQuoteBottomTabsActivity.class));
                break;
            case R.id.tvSearch:
            case R.id.ivSearch:
                if (etSearch.getVisibility() == View.INVISIBLE) {
                    etSearch.setVisibility(View.VISIBLE);
                    etSearch.requestFocus();
                }
                break;
        }
    }


    //region server response

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof HealthDeleteResponse) {
            if (response.getStatusNo() == 0) {
                mQuoteList.remove(removeQuoteEntity);
                healthQuoteAdapter.refreshAdapter(mQuoteList);
                healthQuoteAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
    }

    //endregion
}
