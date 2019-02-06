package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class IllustrationRequestEntity {
        /**
         * PlanTerm : 20
         * SumAssured : 5000000
         * PaymentMode : Y
         * DOB : 15/Dec/1988
         * HdfcPrem : 6784
         * HdfcBasicPrem : 6504
         * TotalPrem : 56263
         * BasicPrem : 53840
         * PremPaidUL : 63047
         * hdfcGst1 : 280
         * hdfcGst2 : 0
         * licGst1 : 2423
         * licGst2 : 1211
         */

        private int PlanTerm;
        private int SumAssured;
        private String PaymentMode;
        private String DOB;
        private int HdfcPrem;
        private int HdfcBasicPrem;
        private int TotalPrem;
        private int BasicPrem;
        private int PremPaidUL;
        private int hdfcGst1;
        private int hdfcGst2;
        private int licGst1;
        private int licGst2;

        public int getPlanTerm() {
            return PlanTerm;
        }

        public void setPlanTerm(int PlanTerm) {
            this.PlanTerm = PlanTerm;
        }

        public int getSumAssured() {
            return SumAssured;
        }

        public void setSumAssured(int SumAssured) {
            this.SumAssured = SumAssured;
        }

        public String getPaymentMode() {
            return PaymentMode;
        }

        public void setPaymentMode(String PaymentMode) {
            this.PaymentMode = PaymentMode;
        }

        public String getDOB() {
            return DOB;
        }

        public void setDOB(String DOB) {
            this.DOB = DOB;
        }

        public int getHdfcPrem() {
            return HdfcPrem;
        }

        public void setHdfcPrem(int HdfcPrem) {
            this.HdfcPrem = HdfcPrem;
        }

        public int getHdfcBasicPrem() {
            return HdfcBasicPrem;
        }

        public void setHdfcBasicPrem(int HdfcBasicPrem) {
            this.HdfcBasicPrem = HdfcBasicPrem;
        }

        public int getTotalPrem() {
            return TotalPrem;
        }

        public void setTotalPrem(int TotalPrem) {
            this.TotalPrem = TotalPrem;
        }

        public int getBasicPrem() {
            return BasicPrem;
        }

        public void setBasicPrem(int BasicPrem) {
            this.BasicPrem = BasicPrem;
        }

        public int getPremPaidUL() {
            return PremPaidUL;
        }

        public void setPremPaidUL(int PremPaidUL) {
            this.PremPaidUL = PremPaidUL;
        }

        public int getHdfcGst1() {
            return hdfcGst1;
        }

        public void setHdfcGst1(int hdfcGst1) {
            this.hdfcGst1 = hdfcGst1;
        }

        public int getHdfcGst2() {
            return hdfcGst2;
        }

        public void setHdfcGst2(int hdfcGst2) {
            this.hdfcGst2 = hdfcGst2;
        }

        public int getLicGst1() {
            return licGst1;
        }

        public void setLicGst1(int licGst1) {
            this.licGst1 = licGst1;
        }

        public int getLicGst2() {
            return licGst2;
        }

        public void setLicGst2(int licGst2) {
            this.licGst2 = licGst2;
        }
    }