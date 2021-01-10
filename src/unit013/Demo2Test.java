package unit013;

public class Demo2Test {
    public static void main(String args[]){
        Demo2 demo = new Demo2();
        // 不存在两个字串相同
        demo.setStr1("asdafghjka");
        demo.setStr2("aaasdfg");
        System.out.println("测试1：str1=" + demo.getStr1() + ",str2=" + demo.getStr2() + "，最大相同子串:\"" + demo.getMaxSubString() + "\"。");

        // 存在两个子串相同的情况
        demo.setStr1("asdafghjka");
        demo.setStr2("aaasdefgh");
        System.out.println("测试2：str1=" + demo.getStr1() + ",str2=" + demo.getStr2() + "，最大相同子串:\"" + demo.getMaxSubString() + "\"。");
    }
}
