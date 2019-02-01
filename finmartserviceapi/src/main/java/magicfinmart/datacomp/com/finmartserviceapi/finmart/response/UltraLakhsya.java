package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UltraLakhsyaEntity;

/**
 * Created by Rajeev Ranjan on 01/02/2019.
 */

public class UltraLakhsya extends APIResponse {
    /**
     * MasterData : {"DeathBenefit":[{"Year":"1","JeevanPremiumPaid":"5432","JeevanBenefitsPayable":"546146","LakshyaPremiumPaid":"746","LakshyaBenefitsPayable":"58969"},{"Year":"1","JeevanPremiumPaid":"5432","JeevanBenefitsPayable":"546146","LakshyaPremiumPaid":"746","LakshyaBenefitsPayable":"58969"},{"Year":"1","JeevanPremiumPaid":"5432","JeevanBenefitsPayable":"546146","LakshyaPremiumPaid":"746","LakshyaBenefitsPayable":"58969"}]}
     */

    private UltraLakhsyaEntity MasterData;

    public UltraLakhsyaEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(UltraLakhsyaEntity MasterData) {
        this.MasterData = MasterData;
    }



    /**
     * MasterData : {"DeathBenefit":[{"Year":"1","JeevanPremiumPaid":"5432","JeevanBenefitsPayable":"546146","LakshyaPremiumPaid":"746","LakshyaBenefitsPayable":"58969"},{"Year":"1","JeevanPremiumPaid":"5432","JeevanBenefitsPayable":"546146","LakshyaPremiumPaid":"746","LakshyaBenefitsPayable":"58969"},{"Year":"1","JeevanPremiumPaid":"5432","JeevanBenefitsPayable":"546146","LakshyaPremiumPaid":"746","LakshyaBenefitsPayable":"58969"}]}
     */


}
