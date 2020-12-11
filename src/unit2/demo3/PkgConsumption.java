package unit2.demo3;

public abstract class PkgConsumption {
    private double feePerMonth;

    public PkgConsumption(double feePerMonth){
        this.feePerMonth = feePerMonth;
    }

    public abstract void show();

    public double getFeePerMonth() {
        return feePerMonth;
    }

    public void setFeePerMonth(double feePerMonth) {
        this.feePerMonth = feePerMonth;
    }
}
