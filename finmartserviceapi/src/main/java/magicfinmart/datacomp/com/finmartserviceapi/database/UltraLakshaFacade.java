package magicfinmart.datacomp.com.finmartserviceapi.database;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DeathBenefitEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HDFCEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.IllustrationRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LICEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LakshyaBenefitIllustratorEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LicVrsList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PageTwoStandAloneList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.PageoneUnmatchedList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ProductComboList;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakshaIllustrationResponseNew;
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

    public boolean removeUltraLakshya()
    {
        editor.remove(ULTRA_LAKSHA_RESPONSE);
        editor.remove(ULTRA_LAKSHA_ILLUSTRATION_RESPONSE);
        return editor.commit();
    }
    //region save response

    public boolean saveRecalculateUltraLaksha(UltraLakshaRecalculateResponse response) {
        Gson gson = new Gson();
        editor.remove(ULTRA_LAKSHA_RESPONSE);
        editor.putString(ULTRA_LAKSHA_RESPONSE, gson.toJson(response));
        return editor.commit();
    }



    public boolean saveUltraLakshaIllustration(UltraLakshaIllustrationResponseNew response) {
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

    public IllustrationRequestEntity getIllustrationRequestEntity() {

        if (getUltraLaksha() != null) {

            if (getUltraLaksha().getMasterData().getIllustrationrequest() != null)
                return getUltraLaksha().getMasterData().getIllustrationrequest().get(0);
            else
                return null;
        }
        return null;
    }

    //endregion

    //region ultra laksh illustration

    private UltraLakshaIllustrationResponseNew getIllustration() {

        try {
            Gson gson = new Gson();
            UltraLakshaIllustrationResponseNew r̥esponse = gson.fromJson(sharedPreferences.getString(ULTRA_LAKSHA_ILLUSTRATION_RESPONSE, ""), UltraLakshaIllustrationResponseNew.class);

            if (r̥esponse != null) {
                return r̥esponse;
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    public List<UltraLakshaIllustrationResponseNew.MasterDataBean.PageoneUnmatchedBean> getPageoneUnmatchedList() {

        if (getIllustration() != null) {
            if (getIllustration().getMasterData().getPageoneUnmatched() != null)
                return getIllustration().getMasterData().getPageoneUnmatched();
            else
                return null;
        }
        return null;
    }


    public List<UltraLakshaIllustrationResponseNew.MasterDataBean.DeathBenefitBean> getDeathBenefitList() {

        if (getIllustration() != null) {
            if (getIllustration().getMasterData().getDeathBenefit() != null)
                return getIllustration().getMasterData().getDeathBenefit();
            else
                return null;
        }
        return null;
    }

    public List<UltraLakshaIllustrationResponseNew.MasterDataBean.BenefitsBean> getBenefitList() {

        if (getIllustration() != null) {
            if (getIllustration().getMasterData().getBenefits() != null)
                return getIllustration().getMasterData().getBenefits();
            else
                return null;
        }
        return null;
    }


    public List<UltraLakshaIllustrationResponseNew.MasterDataBean.PageTwoStandAloneBean> getPageTwoStandAloneList() {

        if (getIllustration() != null) {
            if (getIllustration().getMasterData().getPageTwoStandAlone() != null)
                return getIllustration().getMasterData().getPageTwoStandAlone();
            else
                return null;
        }
        return null;
    }

    public List<UltraLakshaIllustrationResponseNew.MasterDataBean.ProductComboBean> getProductComboList() {

        if (getIllustration() != null) {
            if (getIllustration().getMasterData().getProductCombo() != null)
                return getIllustration().getMasterData().getProductCombo();
            else
                return null;
        }
        return null;
    }

    public List<UltraLakshaIllustrationResponseNew.MasterDataBean.LicVrsBean> getLicVrs() {
//
//
        if (getIllustration() != null) {
            if (getIllustration().getMasterData().getLicVrs() != null)
                return getIllustration().getMasterData().getLicVrs();
            else
                return null;
        }

        return null;
    }

    public List<UltraLakshaIllustrationResponseNew.MasterDataBean.BenefitsPopupBean> getBenefitPopupList() {

        if (getIllustration() != null) {
            if (getIllustration().getMasterData().getBenefitsPopup() != null)
                return getIllustration().getMasterData().getBenefitsPopup();
            else
                return null;
        }
        return null;
    }


    public List<UltraLakshaIllustrationResponseNew.MasterDataBean.SampleScenarioEntity> getSampleScenarioList() {

        if (getIllustration() != null) {
            if (getIllustration().getMasterData().getSampleScenarioLst() != null)
                return getIllustration().getMasterData().getSampleScenarioLst();
            else
                return null;
        }
        return null;
    }
    //endregion
}
