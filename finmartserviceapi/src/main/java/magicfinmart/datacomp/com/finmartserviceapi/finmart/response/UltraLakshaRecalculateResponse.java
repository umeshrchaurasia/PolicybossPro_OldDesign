package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UltraLakshaContainer;

public class UltraLakshaRecalculateResponse extends APIResponse {


    /**
     * MasterData : {"HDFC":[{"CustomerReferenceID":218392,"QuoteId":1,"PolicyTermYear":20,"PPT":0,"InsurerName":"HDFC Life Insurance Co. Ltd.","InsurerLogoName":"HDFC_Life.png","InsurerId":28,"ProductPlanId":"55","ProductPlanName":"HDFC Life Click 2 Protect 3D Plus","Insurer_Plan_Code":null,"NetPremium":11047,"ServiceTax":476,"ServiceTax1":0,"SumAssured":10000000,"IsOnlinePayment":true,"KeyFeatures":"Financial protection at an affordable cost|Choice of 9 plan options|In - built premium waiver for accidental total permanent disability|Premium waiver on diagnosis of specified critical illness(select options)| Whole life protection available|Flexibility to choose policy and premium terms|  Increasing life cover option on key milestones without medicals|Flexibility to increase your cover every year through topup option|Special premium rates for female lives|Attractive premium rates for non - tobacco users|Tax benefits * as per prevailing tax laws","BroucherDownloadLink":"","IsInsurerGateways":true,"PremiumTakenForNoOfMonth":0,"PaymentModeFactor":0,"ApplicationNumber":"1200020762771","HDFCQuotationNumber":"","PdfUrl":"","ProposerPageUrl":"https://qa.policyboss.com/TermInsuranceIndia/HDFCProposal?CustomerReferenceNumber=218392&SelectedQuoteId=1&SupportsAgentID=0&CallingSource=POSPAPP&IsCustomer=0","QuoteStatus":"Success"}],"LIC":[{"CustomerReferenceID":218392,"QuoteId":2,"PolicyTermYear":20,"PPT":0,"InsurerName":"Life Insurance Corporation of India","InsurerLogoName":"lic.png","InsurerId":31,"ProductPlanId":"399","ProductPlanName":"LIC Ultra Akshay","Insurer_Plan_Code":null,"NetPremium":53840,"ServiceTax":2423,"ServiceTax1":1211,"SumAssured":10000000,"IsOnlinePayment":true,"KeyFeatures":"Coverage against death|terminal illness and disability|Option to choose Accidental Death Benefit and Accelerated Critical Illness Benefit|Special premium rates for non - tobacco users|Option to receive the benefit amount as lump sum or monthly income or combination of both|Flexibility to pay premiums once|for a limited period or throughout the policy term|Tax benefits: on premiums paid and benefits received as per the prevailing tax laws","BroucherDownloadLink":"","IsInsurerGateways":true,"PremiumTakenForNoOfMonth":0,"PaymentModeFactor":0,"ApplicationNumber":"","HDFCQuotationNumber":"","PdfUrl":"","ProposerPageUrl":"","QuoteStatus":"Success"}]}
     */

    private UltraLakshaContainer MasterData;

    public UltraLakshaContainer getMasterData() {
        return MasterData;
    }

    public void setMasterData(UltraLakshaContainer MasterData) {
        this.MasterData = MasterData;
    }


}
