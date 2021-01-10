package unit012;

public class Demo1Test {
    public static void main(String[] args) throws InterruptedException {
        Demo1 demo = new Demo1();
        demo.genArray(16, 16);
        demo.calcSum();
        Thread.sleep(2000);
        System.out.println("===数组行元素之和===");
        int[] rowsSumArr = demo.getRowsSumArr();
        for(int i=0; i<rowsSumArr.length; i++){
            System.out.println("第" + (i+1) + "行【" + rowsSumArr[i] + "】");
        }
        Thread.sleep(2000);
        System.out.println("===数组列元素之和===");
        int[] colsSumArr = demo.getColsSumArr();
        for(int i=0; i<colsSumArr.length; i++){
            System.out.println("第" + (i+1) + "列【" + colsSumArr[i] + "】");
        }
        Thread.sleep(2000);
        int tl2brSum = demo.getTl2brSum();
        System.out.println("数组左上角到右下角的元素之和【" + tl2brSum + "】");
        Thread.sleep(2000);
        int tr2blSum = demo.getTr2blSum();
        System.out.println("数组右上角到左下角的元素之和【" + tr2blSum + "】");
    }
}
