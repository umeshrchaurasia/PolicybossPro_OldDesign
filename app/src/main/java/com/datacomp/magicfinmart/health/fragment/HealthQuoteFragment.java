package com.datacomp.magicfinmart.health.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.healthquotetabs.HealthQuoteBottomTabsActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.health.HealthController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuoteExpResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuoteResponse;

/**
 * Created by Nilesh Birhade on 14/02/2018.
 */

public class HealthQuoteFragment extends BaseFragment implements IResponseSubcriber {

    private static final String FLOATER = "FLOATER STANDARD";
    private static final String INDIVIDUAL = "INDIVIDUAL STANDARD";
    TextView txtCoverType, txtCoverAmount;
    HealthQuote healthQuote;
    LinearLayout llMembers;
    ImageView webViewLoader;
    // RecyclerView rvHealthQuote;
    HealthQuoteAdapter adapter;


    ExpandableListView elvHealthQuote;
    HealthQuoteExpandableListAdapter mAdapter;

    List<HealthQuoteEntity> listDataHeader;
    HashMap<HealthQuoteEntity, List<HealthQuoteEntity>> listDataChild;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_healthcontent_quote, container, false);
        initView(view);
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<HealthQuoteEntity, List<HealthQuoteEntity>>();

        if (getArguments() != null) {
            if (getArguments().getParcelable(HealthQuoteBottomTabsActivity.QUOTE_DATA) != null) {
                healthQuote = getArguments().getParcelable(HealthQuoteBottomTabsActivity.QUOTE_DATA);
                bindHeaders();
                fetchQuotes();
            }
        }

        return view;
    }

    private void bindHeaders() {

        if (healthQuote.getHealthRequest().getMemberList().size() > 1) {
            txtCoverType.setText(FLOATER);
        } else {
            txtCoverType.setText(INDIVIDUAL);
        }

        String cover = "COVER :" + "<b>" + String.valueOf(healthQuote.getHealthRequest().getSumInsured()) + "</b>";
        txtCoverAmount.setText(Html.fromHtml(cover));
        bindImages(healthQuote.getHealthRequest().getMemberList());

    }

    private void bindImages(List<MemberListEntity> listmember) {

        for (int i = 0; i < listmember.size(); i++) {

            ImageView imageview = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout
                    .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

            if (listmember.get(i).getAge() > 18)
                imageview.setImageResource(R.mipmap.adult);
            else
                imageview.setImageResource(R.mipmap.child);

            imageview.setLayoutParams(params);
            llMembers.addView(imageview);
        }
    }

    private void initView(View view) {
        webViewLoader = (ImageView) view.findViewById(R.id.webViewLoader);
        txtCoverAmount = (TextView) view.findViewById(R.id.txtCoverAmount);
        txtCoverType = (TextView) view.findViewById(R.id.txtCoverType);
        llMembers = (LinearLayout) view.findViewById(R.id.llMembers);
//        rvHealthQuote = (RecyclerView) view.findViewById(R.id.rvHealthQuote);
//        rvHealthQuote.setHasFixedSize(true);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        rvHealthQuote.setLayoutManager(layoutManager);

        elvHealthQuote = (ExpandableListView) view.findViewById(R.id.elvHealthQuote);

        // Listview Group click listener
        elvHealthQuote.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                Toast.makeText(getActivity(),
                        "Group Clicked " + listDataHeader.get(groupPosition).getInsurerId(),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        elvHealthQuote.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        elvHealthQuote.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(),
                        listDataHeader.get(groupPosition).getPlanName() + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        elvHealthQuote.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getActivity(),
                        "" + listDataHeader.get(groupPosition).getInsurerId()
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition).getInsurerId(), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }


    public void fetchQuotes() {
        visibleLoader();
        //new HealthController(getActivity()).getHealthQuote(healthQuote, this);
        new HealthController(getActivity()).getHealthQuoteExp(healthQuote, this);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        hideLoader();
        if (response instanceof HealthQuoteResponse) {
            if (response.getStatusNo() == 0) {
                List<HealthQuoteEntity> listQuotes =
                        ((HealthQuoteResponse) response).getMasterData().getHealth_quote();

                //adapter = new HealthQuoteAdapter(this, listQuotes);
                //rvHealthQuote.setAdapter(adapter);
            }
        } else if (response instanceof HealthQuoteExpResponse) {
            if (((HealthQuoteExpResponse) response).getMasterData().getHealth_quote().getHeader() != null) {
                prepareChild(((HealthQuoteExpResponse) response).getMasterData()
                        .getHealth_quote().getHeader(), ((HealthQuoteExpResponse) response).getMasterData()
                        .getHealth_quote().getChild());

                mAdapter = new HealthQuoteExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
                elvHealthQuote.setAdapter(mAdapter);

            }
        }

    }

    private void prepareChild(List<HealthQuoteEntity> listHeader, List<HealthQuoteEntity> listChild) {

        for (int i = 0; i < listHeader.size(); i++) {

            HealthQuoteEntity header = listHeader.get(i);
            List<HealthQuoteEntity> childList = new ArrayList<>();

            for (int j = 0; j < listChild.size(); j++) {
                HealthQuoteEntity child = listChild.get(j);
                if (header.getInsurerId() == child.getInsurerId()) {
                    childList.add(child);
                }
            }

            header.setTotalChilds(childList.size());

            listDataChild.put(header, childList);
            listDataHeader.add(header);
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        hideLoader();
        Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void visibleLoader() {
        webViewLoader.setVisibility(View.VISIBLE);
        Glide.with(this).load(R.drawable.preloader).into(webViewLoader);
    }

    private void hideLoader() {
        webViewLoader.setVisibility(View.GONE);
    }
}
