package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model;

public class EmiCalcuatorEntity {

    private double amount;
    private double total;
    private double ttl_payment;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTtl_payment() {
        return ttl_payment;
    }

    public void setTtl_payment(double ttl_payment) {
        this.ttl_payment = ttl_payment;
    }
}
