package unit012;

import unit012.demo3.*;

public class Demo3Test {
    public static void main(String[] args){
        PkgCall pkgCall = new PkgCall(300, 500, 30);
        PkgNet pkgNet = new PkgNet(20480, 5);
        ConsumptionDetail detail = new ConsumptionDetail(200, 24000.6, 20);
        SIMCard card = new SIMCard(
                SIMCardType.SMALL.getCardType(), "13637078253", "suker", "134567", pkgCall, pkgNet, detail);
        card.show();

        //多态
        System.out.println("=======多态信息=======");
        card.info(pkgCall);
        card.info(pkgNet);

    }
}
