package unit012.demo3;
import java.math.BigDecimal;

/**
 * 手机卡类
 * 特征：卡类型、卡号、用户名、密码、账户余额、通话时长(分钟)、上网流量
 * 行为：显示（卡号 + 用户名 + 当前余额）
 */
public class SIMCard {
    private String cardType;
    private String cardNo;
    private String username;
    private String password;
    private double balance;
    // 通话时常（分钟）
    private int callTime;
    //通话时间包
    private PkgCall pkgCall;
    // 上网流量包
    private PkgNet pkgNet;

    private ConsumptionDetail consumptionDetail;

    public SIMCard(String cardType, String cardNo, String username, String password, PkgCall pkgCall, PkgNet pkgNet, ConsumptionDetail consumptionDetail) {
        this.cardType = cardType;
        this.cardNo = cardNo;
        this.username = username;
        this.password = password;
        this.pkgCall = pkgCall;
        this.pkgNet = pkgNet;
        this.consumptionDetail = consumptionDetail;
    }

    public void show(){
        balance = (new BigDecimal(String.valueOf(pkgCall.getFeePerMonth()))).subtract(new BigDecimal(String.valueOf(consumptionDetail.getFee()))).doubleValue();
        System.out.println("手机卡信息：卡号" + cardNo + ",用户名" + username + ",余额" + balance + "元。");
    }

    /* 多态 */
    public void info(PkgConsumption consumption){
        consumption.show();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCallTime() {
        return callTime;
    }

    public void setCallTime(int callTime) {
        this.callTime = callTime;
    }

    public PkgCall getPkgCall() {
        return pkgCall;
    }

    public void setPkgCall(PkgCall pkgCall) {
        this.pkgCall = pkgCall;
    }

    public PkgNet getPkgNet() {
        return pkgNet;
    }

    public void setPkgNet(PkgNet pkgNet) {
        this.pkgNet = pkgNet;
    }
}
