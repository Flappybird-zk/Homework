package unit3;

import java.util.HashMap;
import java.util.Map;

/**
 *  准备一个 HashMap 集合，统计字符串"123,456,789,123,456"中每个数字字符串出现的次数并打印出来。
 *  如：
 *         123 出现了 2 次
 *         456 出现了 2 次
 *         789 出现了 1 次
 */


public class Demo3 {
    private String str;

    public Demo3() {
    }

    public void countNumStr(){
        Map<String, Integer> countMap = new HashMap<>();
        String[] strArr = this.str.split(",");
        for(int i=0; i<strArr.length; i++){
            // 判断是否存在该key
            Integer count = countMap.get(strArr[i]);
            if(count == null){
                countMap.put(strArr[i], 1);
            }else{
                countMap.put(strArr[i], count+1);
            }
        }
        System.out.println("统计\"" + this.str + "\"每个数字字符串的出现次数");
        for(Map.Entry<String, Integer> kv : countMap.entrySet()){
            System.out.println(kv.getKey() + "出现了" + kv.getValue() + "次");
        }
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
