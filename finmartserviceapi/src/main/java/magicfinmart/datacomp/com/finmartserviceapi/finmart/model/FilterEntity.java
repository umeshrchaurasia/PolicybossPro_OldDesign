package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class FilterEntity {
    /**
     * CreditCardAmountFilterId : 1
     * Amount : <2.5Lac
     */

    private int CreditCardAmountFilterId;
    private String Amount;
    private int Priority;

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
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