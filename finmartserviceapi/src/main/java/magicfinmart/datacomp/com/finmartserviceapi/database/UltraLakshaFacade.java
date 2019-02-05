package magicfinmart.datacomp.com.finmartserviceapi.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LakshyaBenefitIllustratorEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DeathBenefitEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HDFCEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LICEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LicVrsList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PageTwoStandAloneList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PageoneUnmatchedList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ProductComboList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UltraLakshaIllustrationContainer;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaIllustrationResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaRecalculateResponse;
import magicfinmart.datacomp.com.finmartserviceapi.model.BenefitsPopupEntity;

public class UltraLakshaFacade {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context mContext;


    private static final String ULTRA_LAKSHA_RESPONSE = "ultra_laksha_response";
    private static final String ULTRA_LAKSHA_ILLUSTRATION_RESPONSE = "ultra_laksha_illustration_response";

    public UltraLakshaFacade(Context context) {
        mContext = context;
        sharedPreferences = context.getSharedPreferences(PrefManager.PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    //region save response

    public boolean saveRecalculateUltraLaksha(UltraLakshaRecalculateResponse response) {
        Gson gson = new Gson();
        editor.remove(ULTRA_LAKSHA_RESPONSE);
        editor.putString(ULTRA_LAKSHA_RESPONSE, gson.toJson(response));
        return editor.commit();
    }

    public boolean saveUltraLakshaIllustration(UltraLakshaIllustrationResponse response) {
        Gson gson = new Gson();
        editor.remove(ULTRA_LAKSHA_ILLUSTRATION_RESPONSE);
        editor.putString(ULTRA_LAKSHA_ILLUSTRATION_RESPONSE, gson.toJson(response));
        return editor.commit();
    }

    //endregion


    //region retrieve ultra laksh recalculate

    public UltraLakshaRecalculateResponse getUltraLaksha() {
        if (new Gson().fromJson(sharedPreferences.getString(ULTRA_LAKSHA_RESPONSE, "")
                , UltraLakshaRecalculateResponse.class) != null) {
            return new Gson().fromJson(sharedPreferences.getString(ULTRA_LAKSHA_RESPONSE, ""), UltraLakshaRecalculateResponse.class);
        }
        return null;
    }

    public HDFCEntity getUltraLakshaHDFC() {

        if (getUltraLaksha() != null) {

            if (getUltraLaksha().getMasterData().getHDFC() != null)
                return getUltraLaksha().getMasterData().getHDFC().get(0);
            else
                return null;
        }
        return null;
    }

    public LICEntity getUltraLakshaLIC() {

        if (getUltraLaksha() != null) {

            if (getUltraLaksha().getMasterData().getLIC() != null)
                return getUltraLaksha().getMasterData().getLIC().get(0);
            else
                return null;
        }
        return null;
    }

    //endregion

    //region ultra laksh illustration

    private UltraLakshaIllustrationContainer getIllustration() {

//        if (new Gson().fromJson(sharedPreferences.getString(ULTRA_LAKSHA_ILLUSTRATION_RESPONSE, "")
//                , UltraLakshaIllustrationContainer.class) != null) {
//            return new Gson().fromJson(sharedPreferences.getString(ULTRA_LAKSHA_ILLUSTRATION_RESPONSE, ""), UltraLakshaIllustrationContainer.class);
//        }

        Gson gson = new Gson();
        UltraLakshaIllustrationContainer ultraLakshaIllustrationContainer = gson.fromJson(ULTRA_LAKSHA_ILLUSTRATION_RESPONSE, UltraLakshaIllustrationContainer.class);

        if(ultraLakshaIllustrationContainer != null)
        {
            return ultraLakshaIllustrationContainer;
        }
        return null;
    }

    public List<DeathBenefitEntity> getDeathBenefitList() {

        if (getIllustration() != null) {
            if (getIllustration().getDeathBenefit() != null)
                return getIllustration().getDeathBenefit();
            else
                return null;
        }
        return null;
    }

    public List<LakshyaBenefitIllustratorEntity> getBenefitList() {

        if (getIllustration() != null) {
            if (getIllustration().getBenefits() != null)
                return getIllustration().getBenefits();
            else
                return null;
        }
        return null;
    }

    public List<PageoneUnmatchedList> getPageoneUnmatchedList() {

        if (getIllustration() != null) {
            if (getIllustration().getPageoneUnmatched() != null)
                return getIllustration().getPageoneUnmatched();
            else
                return null;
        }
        return null;
    }

    public List<PageTwoStandAloneList> getPageTwoStandAloneList() {

        if (getIllustration() != null) {
            if (getIllustration().getPageTwoStandAlone() != null)
                return getIllustration().getPageTwoStandAlone();
            else
                return null;
        }
        return null;
    }

    public List<ProductComboList> getProductComboList() {

        if (getIllustration() != null) {
            if (getIllustration().getProductCombo() != null)
                return getIllustration().getProductCombo();
            else
                return null;
        }
        return null;
    }

    public List<LicVrsList> getLicVrs() {

        if (getIllustration() != null) {
            if (getIllustration().getLicVrs() != null)
                return getIllustration().getLicVrs();
            else
                return null;
        }
        return null;
    }

    public List<BenefitsPopupEntity> getBenefitPopupList() {

        if (getIllustration() != null) {
            if (getIllustration().getBenefitsPopupList() != null)
                return getIllustration().getBenefitsPopupList();
            else
                return null;
        }
        return null;
    }

    //endregion
}
