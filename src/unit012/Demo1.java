package unit012;

import java.util.Random;

/**
 * 定义一个长度为[16][16]的整型二维数组并输入或指定所有位置的元素值，分别实现二维数组中所有行和所有列中所有元素的累加和并打印。
 * 再分别实现二维数组中左上角到右下角和右上角到左下角所有元素的累加和并打印。
 */
public class Demo1 {
    private int[][] arr;
    // 行元素之和
    private int[] rowsSumArr;
    // 列元素之和
    private int[] colsSumArr;
    // 左上角到右下角
    private int tl2brSum;
    // 右上角到左下角和
    private int tr2blSum;

    public Demo1(){
    }

    /**
     * 生成数组
     * @param rows
     * @param cols
     */
    public void genArray(int rows, int cols){
        arr = new int[rows][cols];
        rowsSumArr = new int[rows];
        colsSumArr = new int[cols];
        Random rnd = new Random();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = rnd.nextInt(10);
                System.out.print(arr[i][j]);
                if(j != arr[i].length - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 元素之和
     * @return
     */
    public void calcSum(){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                rowsSumArr[i] += arr[i][j];
                colsSumArr[j] += arr[i][j];
                if(j == i){
                    tl2brSum += arr[i][j];
                }
                if(i + j == arr[i].length - 1){
                    tr2blSum += arr[i][j];
                }
            }
        }
    }


    public int[] getRowsSumArr() {
        return rowsSumArr;
    }

    public int[] getColsSumArr() {
        return colsSumArr;
    }

    public int getTl2brSum() {
        return tl2brSum;
    }

    public int getTr2blSum() {
        return tr2blSum;
    }
}
