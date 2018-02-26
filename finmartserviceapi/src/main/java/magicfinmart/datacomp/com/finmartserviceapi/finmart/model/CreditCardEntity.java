package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class CreditCardEntity {
            /**
             * CreditCardDetailId : 1
             * CreditCardId : 1
             * CreditCardTypeId : 1
             * ImagePath : null
             * Description : <h3 class="text-left">Titanium Delight Card</h3>
             <ul class="rbl-cr-lst text-left">
             <li>Exclusive Wednesday offers - free movie tickets, value back on groceries &amp; pizzas</li>
             <li>4,000 bonus reward points on crossing spends of Rs. 1.2 lacs</li>
             <li>1 Reward point on every Rs.100 spent except fuel</li>
             <li>Waiver of fuel surcharge up to Rs. 100 every month</li>
             <li>Joining Fee Rs.750</li>
             </ul>
             * RBID : 1
             * BankName : RBL  CREDIT CARD
             * CreditCardType : Titanium Delight Card
             * CreditCardAmountFilterId : 1
             * Amount : <2.5Lac
             */

            private int CreditCardDetailId;
            private int CreditCardId;
            private String CreditCardTypeId;
            private String ImagePath;
            private String Description;
            private String RBID;
            private String BankName;
            private String CreditCardType;
            private int CreditCardAmountFilterId;
            private String Amount;

            public int getCreditCardDetailId() {
                return CreditCardDetailId;
            }

            public void setCreditCardDetailId(int CreditCardDetailId) {
                this.CreditCardDetailId = CreditCardDetailId;
            }

            public int getCreditCardId() {
                return CreditCardId;
            }

            public void setCreditCardId(int CreditCardId) {
                this.CreditCardId = CreditCardId;
            }

            public String getCreditCardTypeId() {
                return CreditCardTypeId;
            }

            public void setCreditCardTypeId(String CreditCardTypeId) {
                this.CreditCardTypeId = CreditCardTypeId;
            }

            public String getImagePath() {
                return ImagePath;
            }

            public void setImagePath(String ImagePath) {
                this.ImagePath = ImagePath;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public String getRBID() {
                return RBID;
            }

            public void setRBID(String RBID) {
                this.RBID = RBID;
            }

            public String getBankName() {
                return BankName;
            }

            public void setBankName(String BankName) {
                this.BankName = BankName;
            }

            public String getCreditCardType() {
                return CreditCardType;
            }

            public void setCreditCardType(String CreditCardType) {
                this.CreditCardType = CreditCardType;
            }

            public int getCreditCardAmountFilterId() {
                return CreditCardAmountFilterId;
            }

            public void setCreditCardAmountFilterId(int CreditCardAmountFilterId) {
                this.CreditCardAmountFilterId = CreditCardAmountFilterId;
            }

            public String getAmount() {
                return Amount;
            }

            public void setAmount(String Amount) {
                this.Amount = Amount;
            }
        }