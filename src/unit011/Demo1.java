package unit011;

import java.util.Scanner;

/**
 * 提示用户输入年月日信息，判断这一天是这一年中的第几天并打印。
 */

public class Demo1 {
    public static void main(String[] args){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入年：");
            int year = scanner.nextInt();
            System.out.println("请输入月：");
            int month = scanner.nextInt();
            System.out.println("请输入日：");
            int day = scanner.nextInt();

            //2月份天数
            int FebDays = (year%4 == 0 && year%100 != 0) || (year%400 == 0) ? 29 : 28;
            //一年中月份对应天数
            int[] monthDays = {31, FebDays, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            //***判断是否输入了正确的年月日，不做判断了

            /*求日期总天数*/
            int totalDays = 0;
            for(int i=1; i<monthDays.length; i++){
                if(i<=month - 1){
                    totalDays += monthDays[i-1];
                    if(i == month - 1) break;
                }
            }
            totalDays += day;

            System.out.println(year + "-" + month + "-" + day + "是这一年的第" + totalDays + "天");

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
