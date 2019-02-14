package com.datacomp.magicfinmart.ultralaksha.ultralakshya.fragment.quote.content;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.database.UltraLakshaFacade;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaIllustrationResponseNew;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltraLakshayScenarioOfBenefitsDeath extends Fragment {

    TextView txtBasicSumAssured, txtLicfirstPremium, txtLicRenewalPremium, txtOtherYrs1, txtOtherYrs2,
            txtLicJLFifthYearPrem, txtLicEveryYear, txtLicPaidOnMaturity,
            txtYear1, txtDeathCourse, txtYear2, txtYear4,
            txtUltrafirstPremium, txtUltraRenewalPremium, txtLicULFifthYearPrem, txtUltraLumSum, txtUltraEveryYearEndOfTerm, txtUltraEveryMonth, txtUltraPaidOnMaturity, txtUltraEveryMonthPeriod;

    UltraLakshaFacade ultraLakshaFacade;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_ultra_lakshay_scenario_of_benefits_death, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ultraLakshaFacade = new UltraLakshaFacade(getActivity());
        initialize(view);
        bindData();

    }

    private void initialize(View view) {
        txtBasicSumAssured = view.findViewById(R.id.txtBasicSumAssured);
        txtLicfirstPremium = view.findViewById(R.id.txtLicfirstPremium);
        txtLicRenewalPremium = view.findViewById(R.id.txtLicRenewalPremium);
        txtOtherYrs1 = view.findViewById(R.id.txtOtherYrs1);
        txtOtherYrs2 = view.findViewById(R.id.txtOtherYrs2);

        txtLicJLFifthYearPrem = view.findViewById(R.id.txtLicJLFifthYearPrem);
        txtLicEveryYear = view.findViewById(R.id.txtLicEveryYear);
        txtLicPaidOnMaturity = view.findViewById(R.id.txtLicPaidOnMaturity);

        txtYear1 = view.findViewById(R.id.txtYear1);
        txtDeathCourse = view.findViewById(R.id.txtDeathCourse);
        txtYear2 = view.findViewById(R.id.txtYear2);
        txtYear4 = view.findViewById(R.id.txtYear4);

        txtUltrafirstPremium = view.findViewById(R.id.txtUltrafirstPremium);
        txtUltraRenewalPremium = view.findViewById(R.id.txtUltraRenewalPremium);
        txtLicULFifthYearPrem = view.findViewById(R.id.txtLicULFifthYearPrem);
        txtUltraLumSum = view.findViewById(R.id.txtUltraLumSum);
        txtUltraEveryYearEndOfTerm = view.findViewById(R.id.txtUltraEveryYearEndOfTerm);

        txtUltraEveryMonth = view.findViewById(R.id.txtUltraEveryMonth);
        txtUltraPaidOnMaturity = view.findViewById(R.id.txtUltraPaidOnMaturity);
        txtUltraEveryMonthPeriod = view.findViewById(R.id.txtUltraEveryMonthPeriod);


    }

    private void bindData() {
        if (ultraLakshaFacade.getSampleScenarioList() != null) {
            UltraLakshaIllustrationResponseNew.MasterDataBean.SampleScenarioEntity sampleScenarioEntity = ultraLakshaFacade.getSampleScenarioList().get(0);

            // set the style
            int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
            //region  txtLicEveryYear
            SpannableStringBuilder LicEveryYearBuilder = new SpannableStringBuilder();
            SpannableString LicEveryYearAmnt = new SpannableString("" + sampleScenarioEntity.getLicJLAnnBenefit());
            LicEveryYearAmnt.setSpan(new StyleSpan(Typeface.BOLD), 0, LicEveryYearAmnt.length(), flag);
            SpannableString desctext = new SpannableString(" every year till end of the term");

            LicEveryYearBuilder.append(LicEveryYearAmnt);
            txtLicEveryYear.setText("");
            txtLicEveryYear.append(LicEveryYearAmnt);
            txtLicEveryYear.append(desctext);
            //endregion

            //region  txtLic paid on maturity
            SpannableStringBuilder LicPaidMaturityBuilder = new SpannableStringBuilder();
            SpannableString LicPaidMaturityAmnt = new SpannableString("" + sampleScenarioEntity.getLicJLMatBenefit());
            LicPaidMaturityAmnt.setSpan(new StyleSpan(Typeface.BOLD), 0, LicPaidMaturityAmnt.length(), flag);
            SpannableString LicPaidMaturitytext = new SpannableString("  paid on\nmaturity date");

            LicPaidMaturityBuilder.append(LicPaidMaturityAmnt);
            txtLicPaidOnMaturity.setText("");
            txtLicPaidOnMaturity.append(LicPaidMaturityAmnt);
            txtLicPaidOnMaturity.append(LicPaidMaturitytext);
            //endregion

            //region  txtUltraPaidOnMaturity
            SpannableStringBuilder UltraPaidOnMaturityBuilder = new SpannableStringBuilder();
            SpannableString UltraPaidOnMaturityAmnt = new SpannableString("" + sampleScenarioEntity.getLicULMatBenefit());
            UltraPaidOnMaturityAmnt.setSpan(new StyleSpan(Typeface.BOLD), 0, UltraPaidOnMaturityAmnt.length(), 0);
            SpannableString UltraPaidOnMaturityText = new SpannableString(" paid on\nmaturity date");

            UltraPaidOnMaturityBuilder.append(UltraPaidOnMaturityAmnt);

            txtUltraPaidOnMaturity.setText("");
            txtUltraPaidOnMaturity.append(UltraPaidOnMaturityAmnt);
            txtUltraPaidOnMaturity.append(UltraPaidOnMaturityText);
            //endregion

            //region  txtUltraEveryMonthPeriod
            SpannableStringBuilder UltraEveryMonthPeriodBuilder = new SpannableStringBuilder();
            SpannableString UltraEveryMonthPeriodAmnt = new SpannableString(""
                    + sampleScenarioEntity.getLicULMonthlyBenefitCont());
            UltraEveryMonthPeriodAmnt.setSpan(new StyleSpan(Typeface.BOLD), 0, UltraEveryMonthPeriodAmnt.length(), 0);
            SpannableString UltraEveryMonthPeriodText = new SpannableString(" every month\ncontinues in this period");

            UltraEveryMonthPeriodBuilder.append(UltraEveryMonthPeriodAmnt);
            txtUltraEveryMonthPeriod.setText("");
            txtUltraEveryMonthPeriod.append(UltraEveryMonthPeriodAmnt);
            txtUltraEveryMonthPeriod.append(UltraEveryMonthPeriodText);
            //endregion

            //region  txtUltraLumSum
            SpannableStringBuilder UltraLumSumBuilder = new SpannableStringBuilder();
            SpannableString UltraLumSumAmnt = new SpannableString("" + sampleScenarioEntity.getLicULLumpsumClaim());
            UltraLumSumAmnt.setSpan(new StyleSpan(Typeface.BOLD), 0, UltraLumSumAmnt.length(), 0);
            SpannableString UltraLumSumText = new SpannableString(" paid in\nlump sum");

            UltraLumSumBuilder.append(UltraLumSumAmnt);
            txtUltraLumSum.setText("");
            txtUltraLumSum.append(UltraLumSumAmnt);
            txtUltraLumSum.append(UltraLumSumText);
            //endregion

            //region  txtUltraEveryYearEndOfTerm
            SpannableStringBuilder UltraEveryYearBuilder = new SpannableStringBuilder();
            SpannableString UltraEveryYearAmnt = new SpannableString(""+sampleScenarioEntity.getLicULAnnBenefit());
            UltraEveryYearAmnt.setSpan(new StyleSpan(Typeface.BOLD),0,UltraEveryYearAmnt.length(),0);
            SpannableString UltraEveryYearText = new SpannableString(" every year\ntill end of term");

            UltraEveryYearBuilder.append(UltraEveryYearAmnt );
            txtUltraEveryYearEndOfTerm.setText("");
            txtUltraEveryYearEndOfTerm.append(UltraEveryYearAmnt);
            txtUltraEveryYearEndOfTerm.append(UltraEveryYearText);
            //endregion

            //region  txtUltraEveryMonth
            SpannableStringBuilder UltraEveryMonthBuilder = new SpannableStringBuilder();
            SpannableString UltraEveryMonthAmnt = new SpannableString(""+sampleScenarioEntity.getLicULMonthlyBenefit());
            UltraEveryMonthAmnt.setSpan(new StyleSpan(Typeface.BOLD),0,UltraEveryMonthAmnt.length(),0);
            SpannableString UltraEveryMonthText = new SpannableString(" every month" + "\n" + sampleScenarioEntity.getLicULMonthlyBenefityears());

            UltraEveryMonthBuilder.append(UltraEveryMonthAmnt );
            txtUltraEveryMonth.setText("");
            txtUltraEveryMonth.append(UltraEveryMonthAmnt);
            txtUltraEveryMonth.append(UltraEveryMonthText);
            //endregion

            txtBasicSumAssured.setText("" + sampleScenarioEntity.getBasicSumAssured());
            txtLicfirstPremium.setText("" + sampleScenarioEntity.getLicJLFirstPrem());
            txtLicRenewalPremium.setText("" + sampleScenarioEntity.getLicJLRenewalPrem());
            txtOtherYrs1.setText("" + sampleScenarioEntity.getOtherYrs());
            txtOtherYrs2.setText("" + sampleScenarioEntity.getOtherYrs());

            txtLicJLFifthYearPrem.setText("" + sampleScenarioEntity.getLicJLFifthYearPrem());

            txtYear1.setText("" + sampleScenarioEntity.getLicFirstYear());
            txtDeathCourse.setText("" + sampleScenarioEntity.getLicFifthYear());
            txtYear2.setText("" + sampleScenarioEntity.getLicLastYear());
            txtYear4.setText("" + sampleScenarioEntity.getLicBenefitYear());

            txtUltrafirstPremium.setText("" + sampleScenarioEntity.getLicULFirstPrem());
            txtUltraRenewalPremium.setText("" + sampleScenarioEntity.getLicULRenewalPrem());
            txtLicULFifthYearPrem.setText("" + sampleScenarioEntity.getLicULFifthYearPrem());



        }
    }

}
