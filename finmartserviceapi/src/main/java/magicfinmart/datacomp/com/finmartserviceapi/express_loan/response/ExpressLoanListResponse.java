package magicfinmart.datacomp.com.finmartserviceapi.express_loan.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by IN-RB on 03-04-2018.
 */

public class ExpressLoanListResponse extends APIResponse {


    /**
     * MasterData : {"PersonalLoan":[{"Bank_Id":43,"Bank_Name":"RATNAKAR BANK LTD","Bank_Code":"RBL","Document1":"http://erp.rupeeboss.com/Banklogo/rbl_bank.jpg","WebView":0},{"Bank_Id":33,"Bank_Name":"KOTAK MAHINDRA BANK","Bank_Code":"KOTAK MAHINDRA","Document1":"http://erp.rupeeboss.com/Banklogo/kotak.png","WebView":0},{"Bank_Id":27,"Bank_Name":"IIFL","Bank_Code":"IIFL","Document1":"http://erp.rupeeboss.com/Banklogo/iifl.png","WebView":1},{"Bank_Id":20,"Bank_Name":"HDFC BANK LTD","Bank_Code":"HDFC","Document1":"http://erp.rupeeboss.com/Banklogo/hdfc.png","WebView":0}],"ShortTermPersonalLoan":[{"Bank_Id":999,"Bank_Name":"SHORT TERM PERSONAL LOAN","Bank_Code":"STPL","Document1":"http://www.rupeeboss.com/images/express/early.png","WebView":0}]}
     */

    private ExpressLoanEntity MasterData;

    public ExpressLoanEntity getMasterData() {
        return MasterData;
    }

    public void setMasterData(ExpressLoanEntity MasterData) {
        this.MasterData = MasterData;
    }

    public static class ExpressLoanEntity {
        private List<PersonalLoanEntity> PersonalLoan;
        private List<ShortTermPersonalLoanEntity> ShortTermPersonalLoan;

        public List<PersonalLoanEntity> getPersonalLoan() {
            return PersonalLoan;
        }

        public void setPersonalLoan(List<PersonalLoanEntity> PersonalLoan) {
            this.PersonalLoan = PersonalLoan;
        }

        public List<ShortTermPersonalLoanEntity> getShortTermPersonalLoan() {
            return ShortTermPersonalLoan;
        }

        public void setShortTermPersonalLoan(List<ShortTermPersonalLoanEntity> ShortTermPersonalLoan) {
            this.ShortTermPersonalLoan = ShortTermPersonalLoan;
        }

        public static class PersonalLoanEntity {
            /**
             * Bank_Id : 43
             * Bank_Name : RATNAKAR BANK LTD
             * Bank_Code : RBL
             * Document1 : http://erp.rupeeboss.com/Banklogo/rbl_bank.jpg
             * WebView : 0
             */

            private int Bank_Id;
            private String Bank_Name;
            private String Bank_Code;
            private String Document1;
            private int WebView;

            public int getBank_Id() {
                return Bank_Id;
            }

            public void setBank_Id(int Bank_Id) {
                this.Bank_Id = Bank_Id;
            }

            public String getBank_Name() {
                return Bank_Name;
            }

            public void setBank_Name(String Bank_Name) {
                this.Bank_Name = Bank_Name;
            }

            public String getBank_Code() {
                return Bank_Code;
            }

            public void setBank_Code(String Bank_Code) {
                this.Bank_Code = Bank_Code;
            }

            public String getDocument1() {
                return Document1;
            }

            public void setDocument1(String Document1) {
                this.Document1 = Document1;
            }

            public int getWebView() {
                return WebView;
            }

            public void setWebView(int WebView) {
                this.WebView = WebView;
            }
        }

        public static class ShortTermPersonalLoanEntity {
            /**
             * Bank_Id : 999
             * Bank_Name : SHORT TERM PERSONAL LOAN
             * Bank_Code : STPL
             * Document1 : http://www.rupeeboss.com/images/express/early.png
             * WebView : 0
             */

            private int Bank_Id;
            private String Bank_Name;
            private String Bank_Code;
            private String Document1;
            private int WebView;

            public int getBank_Id() {
                return Bank_Id;
            }

            public void setBank_Id(int Bank_Id) {
                this.Bank_Id = Bank_Id;
            }

            public String getBank_Name() {
                return Bank_Name;
            }

            public void setBank_Name(String Bank_Name) {
                this.Bank_Name = Bank_Name;
            }

            public String getBank_Code() {
                return Bank_Code;
            }

            public void setBank_Code(String Bank_Code) {
                this.Bank_Code = Bank_Code;
            }

            public String getDocument1() {
                return Document1;
            }

            public void setDocument1(String Document1) {
                this.Document1 = Document1;
            }

            public int getWebView() {
                return WebView;
            }

            public void setWebView(int WebView) {
                this.WebView = WebView;
            }
        }
    }
}
