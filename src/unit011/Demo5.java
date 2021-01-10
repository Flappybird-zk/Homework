package unit011;

/**
 * 使用双重循环实现五子棋游戏棋盘的绘制
 */

public class Demo5 {
    public static void main(String[] args){
        //初始化
        char[][] arr = new char[17][17];

        //二维数组赋值
        char[] initChars = {' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        arr[0] = initChars;
        for(int i=1; i<arr.length; i++){
            arr[i][0] = initChars[i];
            for(int j=1; j<arr[i].length; j++){
                arr[i][j] = '+';
            }
        }

        //遍历二维数组并打印
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]);
                if(j != arr[i].length - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
