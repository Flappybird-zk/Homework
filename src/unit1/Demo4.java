package unit1;

import  java.util.Random;

/**
 * 自定义数组扩容规则，当已存储元素数量达到总容量的 80%时，扩容 1.5 倍。
 * 例如，总容量是 10，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15。
 */

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        int initLen = 10;
        int[] arr = new int[initLen];
        // 扩容的临界值
        int extendMaxNum = arr.length * 8 / 10;

        int i = 0;
        Random random = new Random();
        while(true){
            arr[i++] = random.nextInt(100);
            if(i >= extendMaxNum){
                System.out.print("输入了第" + extendMaxNum + "个元素，数组总容量已达到80%，将扩容1.5倍，");

                //数组新的长度
                int newLen = arr.length * 15 / 10;
                int[] newArr = new int[newLen];
                System.arraycopy(arr, 0, newArr, 0, extendMaxNum);
                System.out.print("扩容前长度【" + arr.length + "】");
                arr = newArr;

                //扩容临界值修改
                extendMaxNum = arr.length * 8 / 10;

                System.out.println("，扩容后长度为【"  + newArr.length+ "】");
                Thread.sleep(2000);
            }
        }
    }
}
