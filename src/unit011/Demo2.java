package unit011;

/**
 * 编程找出 1000 以内的所有完数并打印出来。 所谓完数就是一个数恰好等于它的因子之和，如:6=1+2+3
 */

public class Demo2 {
    public static void main(String[] args){
        //完数
        String perfectNumbers = "";

        for(int i = 1; i <= 1000; i++){
            // 因子和
            int sum = 0;
            for(int j=1; j <= i-1; j++){
                if(i%j == 0) sum += j;
            }
            if(sum == i) perfectNumbers += sum + " ";
        }

        System.out.println("1~1000内的完数：" + perfectNumbers);
    }
}
