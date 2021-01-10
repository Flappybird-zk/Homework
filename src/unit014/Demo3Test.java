package unit014;


import unit014.demo3.FileCopy;

public class Demo3Test {
    public static void main(String[] args) throws InterruptedException {
        FileCopy.copy("./dir1", "./dir2");
    }
}
