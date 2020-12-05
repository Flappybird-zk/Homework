package unit2.demo3;

/**
 * 通话套餐类
 * 特征：通话时长、短信条数、每月资费
 * 行为: 显示所有套餐信息
 */
public class PkgCall extends PkgConsumption implements IServiceCall {
    private int callTime;
    private int msgCount;

    public PkgCall(int callTime, int msgCount, double feePerMonth) {
        super(feePerMonth);
        this.callTime = callTime;
        this.msgCount = msgCount;
    }

    public int getCallTime() {
        return callTime;
    }

    public void setCallTime(int callTime) {
        this.callTime = callTime;
    }

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    @Override
    public void show(){
        System.out.println("手机套餐:每月通话时长" + callTime + "分钟,短信" + msgCount + "条,话费：" + this.getFeePerMonth() + "元。");
    }

    @Override
    public void serviceCall(int callTime, SIMCard card) {

    }
}
