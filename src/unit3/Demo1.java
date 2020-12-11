package unit3;

/**
 *  编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打 印出来。
 */

public class Demo1 {
    private String str;

    public Demo1() {
    }

    public void countWord(){
        // 大写字母个数
        int upperCount = 0;
        // 小写字母个数
        int lowerCount = 0;
        // 数字个数
        int numberCount = 0;
        // 其它字符个数
        int otherCount = 0;
        int strLen = this.str.length();
        for(int i=0; i< strLen; i++){
            char c = this.str.charAt(i);
            if(c<='Z' && c>='A'){
                upperCount++;
            }else if(c<='z' && c>='a'){
                lowerCount++;
            }else if(c<='9' && c>='0'){
                numberCount++;
            }else{
                otherCount++;
            }
        }
        System.out.println("字符串\"" + this.str + "\"，统计信息如下：");
        System.out.println("大写字母[" + upperCount + "]个");
        System.out.println("小写字母[" + lowerCount + "]个");
        System.out.println("数字[" + numberCount + "]个");
        System.out.println("其它字符[" + otherCount + "]个");
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }



}
