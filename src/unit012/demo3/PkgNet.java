package unit012.demo3;

/**
 * 上网套餐类
 * 特征：上网流量、每月资费
 * 行为：显示所有套餐信息
 */
public class PkgNet extends PkgConsumption implements IServiceCall {
    private double netFlow;

    public PkgNet(double netFlow, double feePerMonth) {
        super(feePerMonth);
        this.netFlow = netFlow;
    }

    public double getNetFlow() {
        return netFlow;
    }

    public void setNetFlow(int netFlow) {
        this.netFlow = netFlow;
    }

    @Override
    public void show(){
        System.out.println("上网套餐信息:上网流量" + netFlow + "MB, 每月费用：" + this.getFeePerMonth() + "元");
    }

    @Override
    public void serviceCall(int callTime, SIMCard card) {

    }
}
