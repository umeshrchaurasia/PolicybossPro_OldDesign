package com.datacomp.magicfinmart.health.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.healthquotetabs.HealthQuoteBottomTabsActivity;
import com.datacomp.magicfinmart.webviews.CommonWebViewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.health.HealthController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity.HealthCompareRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuoteCompareResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuoteExpResponse;

/**
 * Created by Nilesh Birhade on 14/02/2018.
 */

public class HealthQuoteFragment extends BaseFragment implements IResponseSubcriber, View.OnClickListener {

    private static final String FLOATER = "FLOATER STANDARD";
    private static final String INDIVIDUAL = "INDIVIDUAL STANDARD";
    private static final String SHARE_TEXT = " results from www.policyboss.com";

    TextView txtCoverType, txtCoverAmount;
    HealthQuote healthQuote;
    LinearLayout llMembers;
    ImageView webViewLoader;
    RecyclerView rvHealthQuote;
    HealthQuoteAdapter adapter;
    ImageView ivEdit;
    TextView tvCount, txtCompareCount;

    List<HealthQuoteEntity> listCompare;
    List<HealthQuoteEntity> listDataHeader;
    HashMap<Integer, List<HealthQuoteEntity>> listDataChild;

    HealthQuoteEntity buyHealthQuoteEntity;

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
        setListener();
        listCompare = new ArrayList<>();
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<Integer, List<HealthQuoteEntity>>();
        txtCompareCount.setVisibility(View.GONE);

        if (getArguments() != null) {
            if (getArguments().getParcelable(HealthQuoteBottomTabsActivity.QUOTE_DATA) != null) {
                healthQuote = new HealthQuote();
                healthQuote = getArguments().getParcelable(HealthQuoteBottomTabsActivity.QUOTE_DATA);
                bindHeaders();
                fetchQuotes();
            }
        }

        return view;
    }

    private void setListener() {
        ivEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ivEdit) {
            ((HealthQuoteBottomTabsActivity) getActivity()).redirectToInput();
        }
    }

    private void bindHeaders() {

        if (healthQuote.getHealthRequest().getMemberList().size() > 1) {
            txtCoverType.setText(FLOATER);
        } else {
            txtCoverType.setText(INDIVIDUAL);
        }

        tvCount.setText(SHARE_TEXT);
        String cover = "COVER :" + "<b>" + String.valueOf(healthQuote.getHealthRequest().getSumInsured()) + "</b>";
        txtCoverAmount.setText(Html.fromHtml(cover));
        bindImages(healthQuote.getHealthRequest().getMemberList());

    }

    private void bindImages(List<MemberListEntity> listmember) {

        for (int i = 0; i < listmember.size(); i++) {

            ImageView imageview = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout
                    .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

            imageview.setPadding(2, 0, 2, 0);

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
        tvCount = (TextView) view.findViewById(R.id.tvCount);
        ivEdit = (ImageView) view.findViewById(R.id.ivEdit);

        txtCompareCount = (TextView) view.findViewById(R.id.txtCompareCount);
        rvHealthQuote = (RecyclerView) view.findViewById(R.id.rvHealthQuote);
        rvHealthQuote.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvHealthQuote.setLayoutManager(layoutManager);
    }

    public void redirectToBuy(HealthQuoteEntity entity) {
        buyHealthQuoteEntity = new HealthQuoteEntity();
        buyHealthQuoteEntity = entity;
        HealthCompareRequestEntity compareRequestEntity = new HealthCompareRequestEntity();
        compareRequestEntity.setFba_id(new DBPersistanceController(getContext()).getUserData().getFBAId());
        compareRequestEntity.setAgent_source("App");
        compareRequestEntity.setCrn("");
        compareRequestEntity.setHealthRequest(buyHealthQuoteEntity);

        showDialog("Please wait.., Calculating final premium");
        new HealthController(getActivity()).compareQuote(compareRequestEntity, this);

    }


    public void fetchQuotes() {
        //visibleLoader();
        showDialog("Please wait.., Fetching quotes");
        new HealthController(getActivity()).getHealthQuoteExp(healthQuote, this);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        //hideLoader();
        cancelDialog();
        if (response instanceof HealthQuoteExpResponse) {
            if (((HealthQuoteExpResponse) response).getMasterData().getHealth_quote().getHeader() != null) {

                //update request id
                ((HealthQuoteBottomTabsActivity) getActivity()).updateRequestID(((HealthQuoteExpResponse) response).getMasterData().getHealthRequestId());

                prepareChild(((HealthQuoteExpResponse) response).getMasterData()
                        .getHealth_quote().getHeader(), ((HealthQuoteExpResponse) response).getMasterData()
                        .getHealth_quote().getChild());
            }
        } else if (response instanceof HealthQuoteCompareResponse) {
            dialogMessage((HealthQuoteCompareResponse) response);
        }

    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void dialogMessage(final HealthQuoteCompareResponse healthQuoteCompareResponse) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle("PREMIUM DETAIL");
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_compare_health_quote, null);
        builder.setView(view);
        ImageView imgInsurerLogo = (ImageView) view.findViewById(R.id.imgInsurerLogo);
        TextView txtPlanName = (TextView) view.findViewById(R.id.txtPlanName);
        TextView txtEstPremium = (TextView) view.findViewById(R.id.txtEstPremium);
        TextView txtInsPremium = (TextView) view.findViewById(R.id.txtInsPremium);

        imgInsurerLogo.setImageResource(new DBPersistanceController(getActivity())
                .getInsurerImage(buyHealthQuoteEntity.getInsurerId()));
        txtPlanName.setText("" + buyHealthQuoteEntity.getPlanName());
        txtEstPremium.setText("\u20B9 " + Math.round(buyHealthQuoteEntity.getNetPremium()));
        txtInsPremium.setText("\u20B9 " + Math.round(healthQuoteCompareResponse.getMasterData().getNetPremium()));

        builder.setPositiveButton("BUY", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                Intent intent = new Intent(getActivity(), CommonWebViewActivity.class);
                intent.putExtra("URL", healthQuoteCompareResponse.getMasterData().getProposerPageUrl());
                intent.putExtra("TITLE", "HEALTH INSURENCE");
                intent.putExtra("NAME", "HEALTH INSURENCE");
                startActivity(intent);
            }
        })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
        TextView msgTxt = (TextView) dialog.findViewById(android.R.id.message);
        msgTxt.setTextSize(12.0f);
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

            listDataChild.put(header.getInsurerId(), childList);
            listDataHeader.add(header);

        }
        bindRecyclerView(listDataHeader);
        int total = listHeader.size() + listChild.size();
        tvCount.setText(total + SHARE_TEXT);
    }

    public void bindRecyclerView(List<HealthQuoteEntity> list) {
        adapter = new HealthQuoteAdapter(this, list);
        rvHealthQuote.setAdapter(adapter);

    }

    private void refreshAdapter(List<HealthQuoteEntity> list) {
        adapter.refreshNewQuote(list);
    }

    public void addMoreQuote(int insurerID) {

        List<HealthQuoteEntity> childList = listDataChild.get(insurerID);
        refreshAdapter(childList);
    }

    public void addRemoveCompare(HealthQuoteEntity entity, boolean isAdd) {
        if (isAdd) {
            listCompare.add(entity);
        } else {
            //remove item from list
            for (Iterator<HealthQuoteEntity> iter = listCompare.listIterator(); iter.hasNext(); ) {
                HealthQuoteEntity a = iter.next();
                if (a.getInsurerId() == entity.getInsurerId() && a.getPlanID() == entity.getPlanID()) {
                    iter.remove();
                }
            }
        }

        if (listCompare.size() == 0) {
            txtCompareCount.setVisibility(View.GONE);
        } else {
            txtCompareCount.setVisibility(View.VISIBLE);
            txtCompareCount.setText("" + listCompare.size());
        }
    }


}
