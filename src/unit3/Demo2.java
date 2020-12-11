package unit3;

/**
 * 编程获取两个指定字符串中的最大相同子串。
 *  如： s1="asdafghjka", s2="aaasdfg" 他们的最大子串为"asd"
 *  提示： 将短的那个串进行长度依次递减的子串与较长的串比较。
 */



public class Demo2 {
    private String str1;
    private String str2;

    public Demo2() {
    }

    public String getMaxSubString(){
        // 最大的子字符串
        String maxSubStr = "";

        String minLenStr;
        String maxLenStr;
        int minLen;
        int str1Len = this.str1.length();
        int str2Len = this.str2.length();
        if (str1Len > str2Len) {
            minLenStr = this.str2;
            maxLenStr = this.str1;
            minLen = str2Len;
        } else {
            minLenStr = this.str1;
            maxLenStr = this.str2;
            minLen = str2Len;
        }
//        System.out.println("长度短的字符串\"" + minLenStr + "\"");
//        System.out.println("长度长的字符串\"" + maxLenStr + "\"");
        for(int i=0; i<minLen; i++){
            for(int j=minLen; j>i && j-i>=maxSubStr.length(); j--){
                String subStr =minLenStr.substring(i, j);
//                System.out.println("====" + subStr);
                if(maxLenStr.contains(subStr)){
                    // 长度长的自字符串或长度相同需对比
                    if(subStr.length() > maxSubStr.length() || (subStr.length() == maxSubStr.length() && subStr.compareTo(maxSubStr) > 0)){
                        maxSubStr = subStr;
//                        System.out.println("最大子串为======="+subStr);
                    }
                }
            }
        }
        return maxSubStr;

    }


    public String getStr1() {
        return str1;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }
}
