package com.datacomp.magicfinmart.term.ultralakshya.fragment.quote.content;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.UltraLakshaFacade;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PageTwoStandAloneList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ProductComboList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltraLakshayProductCombo extends BaseFragment {


    TextView txtLicTerm ,txtLicPPT ,txtLicMode ,txtLicSum ,txtOtherYear,
            txtLicPremYearOne,txtLicPremOtherYears,

    txtHdfcTerm,txtHdfcPPT,txtHdfcMode,txtHdfcSum,txtHdfcPremYearOne,txtHdfcPremOtherYears,
            txtTotalOne,txtTotalTwo;

    UltraLakshaFacade ultraLakshaFacade;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ultra_lakshay_product_combo, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
        ultraLakshaFacade = new UltraLakshaFacade(getActivity());

        bindData();
    }

    private void initialize(View view)
    {
        txtLicTerm = view.findViewById(R.id.txtLicTerm);
        txtLicPPT = view.findViewById(R.id.txtLicPPT);
        txtLicMode = view.findViewById(R.id.txtLicMode);

        txtLicSum = view.findViewById(R.id.txtLicSum);
        txtOtherYear = view.findViewById(R.id.txtOtherYear);

        txtLicPremYearOne = view.findViewById(R.id.txtLicPremYearOne);
        txtLicPremOtherYears = view.findViewById(R.id.txtLicPremOtherYears);



        txtHdfcTerm = view.findViewById(R.id.txtHdfcTerm);
        txtHdfcPPT = view.findViewById(R.id.txtHdfcPPT);
        txtHdfcMode = view.findViewById(R.id.txtHdfcMode);

        txtHdfcSum = view.findViewById(R.id.txtHdfcSum);
        txtHdfcPremYearOne = view.findViewById(R.id.txtHdfcPremYearOne);
        txtHdfcPremOtherYears = view.findViewById(R.id.txtHdfcPremOtherYears);

        txtTotalOne = view.findViewById(R.id.txtTotalOne);
        txtTotalTwo = view.findViewById(R.id.txtTotalTwo);

    }


    private void bindData()
    {
        if(ultraLakshaFacade.getProductComboList() != null)
        {

            ProductComboList objComboEntity = ultraLakshaFacade.getProductComboList().get(0);

            txtLicTerm.setText(""+objComboEntity.getLicTerm());
            txtLicPPT.setText(""+objComboEntity.getLicPPT());
            txtLicMode.setText(""+objComboEntity.getLicMode());

            txtLicSum.setText(""+objComboEntity.getLicSum());
            txtOtherYear.setText(""+objComboEntity.getLicYears());

            txtLicPremYearOne.setText(""+objComboEntity.getLicPremYearOne());
            txtLicPremOtherYears.setText(""+objComboEntity.getLicPremOtherYears());
            ///////////////

            txtHdfcTerm.setText(""+objComboEntity.getHdfcTerm());
            txtHdfcPPT.setText(""+objComboEntity.getHdfcPPT());
            txtHdfcMode.setText(""+objComboEntity.getHdfcMode());

            txtHdfcSum.setText(""+objComboEntity.getHdfcSum());
            txtHdfcPremYearOne.setText(""+objComboEntity.getHdfcPremYearOne());
            txtHdfcPremOtherYears.setText(""+objComboEntity.getHdfcPremOtherYears());

            txtTotalOne.setText(""+objComboEntity.getTotalOne());
            txtTotalTwo.setText(""+objComboEntity.getTotalTwo());
        }
    }


}
