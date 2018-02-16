package com.datacomp.magicfinmart.health.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.health.healthquotetabs.HealthQuoteBottomTabsActivity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.health.HealthController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuoteEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MemberListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.HealthQuoteResponse;

/**
 * Created by Rajeev Ranjan on 29/01/2018.
 */

public class HealthQuoteFragment extends BaseFragment implements IResponseSubcriber {

    private static final String FLOATER = "FLOATER STANDARD";
    private static final String INDIVIDUAL = "INDIVIDUAL STANDARD";
    TextView txtCoverType, txtCoverAmount;
    HealthQuote healthQuote;
    LinearLayout llMembers;

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

        if (getArguments() != null) {
            if (getArguments().getParcelable(HealthQuoteBottomTabsActivity.QUOTE_DATA) != null) {
                healthQuote = getArguments().getParcelable(HealthQuoteBottomTabsActivity.QUOTE_DATA);
                bindHeaders();
                // fetchQuotes();
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

            Toast.makeText(getActivity(), "" + i, Toast.LENGTH_SHORT).show();
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
//        imgMember1 = (ImageView) view.findViewById(R.id.imgMember1);
//        imgMember2 = (ImageView) view.findViewById(R.id.imgMember2);
//        imgMember3 = (ImageView) view.findViewById(R.id.imgMember3);
//        imgMember4 = (ImageView) view.findViewById(R.id.imgMember4);
//        imgMember5 = (ImageView) view.findViewById(R.id.imgMember5);
//        imgMember6 = (ImageView) view.findViewById(R.id.imgMember6);
        txtCoverAmount = (TextView) view.findViewById(R.id.txtCoverAmount);
        txtCoverType = (TextView) view.findViewById(R.id.txtCoverType);
        llMembers = (LinearLayout) view.findViewById(R.id.llMembers);
    }


    public void fetchQuotes() {
        showDialog();
        new HealthController(getActivity()).getHealthQuote(healthQuote, this);
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof HealthQuoteResponse) {
            if (response.getStatusNo() == 0) {
                List<HealthQuoteEntity> listQuotes =
                        ((HealthQuoteResponse) response).getMasterData().getHealth_quote();
                Toast.makeText(getActivity(), "No. of Quotes : " + listQuotes.size(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {

    }
}
