package unit011;

import java.lang.Math;
import java.util.Arrays;

/**
 * 实现双色球抽奖游戏中奖号码的生成，中奖号码由 6 个红球号码和 1 个蓝球号码组成。
 * 其中红球号码要求随机生成 6 个 1~33 之间不重复的随机号码。
 * 其中蓝球号码要求随机生成 1 个 1~16 之间的随机号码。
 */
public class Demo3 {
    public static void main(String[] args){
        // 红球号码
        int[] redNumbers = new int[6];
        for(int i=0; i<6; i++){
            int randomInt = 1 + (int)(Math.random() * 33);
            redNumbers[i] = randomInt;
            //检测重复数字
            for(int j=0; j<i; j++){
                if(redNumbers[i] == redNumbers[j]){
                    i--;
                    break;
                }
            }

        }
        Arrays.sort(redNumbers);
//        System.out.println("红球号码：" + Arrays.toString(redNumbers));

        // 篮球号码
        int blueNumber = 1 + (int)(Math.random() * 16);

        String lotteryNumbers = "";
        lotteryNumbers += redNumbers[0];
        for(int i=1; i<redNumbers.length; i++){
            lotteryNumbers += " " + redNumbers[i];
        }
        lotteryNumbers += " + " + blueNumber;

        System.out.println("双色球中奖号码为：" + lotteryNumbers);
    }
}
