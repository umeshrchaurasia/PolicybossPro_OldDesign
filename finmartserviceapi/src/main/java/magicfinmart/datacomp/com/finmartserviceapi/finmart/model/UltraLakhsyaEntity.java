package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.UltraLakhsyaResponse;

public class UltraLakhsyaEntity {

    private List<DeathBenefitEntity> DeathBenefitLst;
    private List<LakshyaBenefitIllustratorEntity> BenefitsLst;

    public List<DeathBenefitEntity> getDeathBenefit() {
        return DeathBenefitLst;
    }

    public void setDeathBenefit(List<DeathBenefitEntity> DeathBenefit) {
        this.DeathBenefitLst = DeathBenefit;
    }


    public List<LakshyaBenefitIllustratorEntity> getBenefits() {
        return BenefitsLst;
    }

    public void setBenefits(List<LakshyaBenefitIllustratorEntity> Benefits) {
        this.BenefitsLst = Benefits;
    }



}
