package unit2.demo3;

public class ConsumptionDetail {
    private int callTime;
    private double netFlow;
    private double fee;
    public ConsumptionDetail(int callTime, double netFlow, double fee){
        this.callTime = callTime;
        this.netFlow = netFlow;
        this.fee = fee;
    }

    public void show() {
        System.out.println("消费信息：您已通话" + callTime + "分钟,流量使用" + netFlow + "MB,消费" + fee + "元。");
    }

    public int getCallTime() {
        return callTime;
    }

    public void setCallTime(int callTime) {
        this.callTime = callTime;
    }

    public double getNetFlow() {
        return netFlow;
    }

    public void setNetFlow(double netFlow) {
        this.netFlow = netFlow;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
