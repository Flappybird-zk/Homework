package unit2;

import java.util.Scanner;

/**
 *  编程实现控制台版并支持两人对战的五子棋游戏。
 * （1）绘制棋盘 - 写一个成员方法实现
 * （2）提示黑方和白方分别下棋并重新绘制棋盘 - 写一个成员方法实现。
 * （3）每当一方下棋后判断是否获胜 - 写一个成员方法实现。
 * （4）提示： 采用二维数组来模拟并描述棋盘，棋盘如下：
 */
public class Demo2 {
    private int rows;
    private int cols;
    private char[][] boardArr;
    // 初始化的棋子字符
    private static char[] INIT_CHESS_CHARS = {
            ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    // 白色棋子
    private static char CHESS_WHITE = 0x25cb;
    // 黑色棋子
    private static char CHESS_BLACK = 0x25cf;
    // 空棋子
    private static char CHESS_EMPTY = '+';

    public Demo2(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        boardArr = new char[rows][cols];
    }

    /**
     * 初始棋盘
     */
    public void initBoard(){
        boardArr[0] = INIT_CHESS_CHARS;
        for(int i=1; i<boardArr.length; i++){
            boardArr[i][0] = INIT_CHESS_CHARS[i];
            for(int j=1; j<boardArr[i].length; j++){
                boardArr[i][j] = CHESS_EMPTY;
            }
        }
    }

    /**
     * 下棋
     */
    public void startGame(){
        // true黑方，false白方
        boolean chessFlag = false;
        boolean win = false;
        Scanner sc = new Scanner(System.in);
        while(true){
            String chessDesc = chessFlag ? "黑方": "白方";
            System.out.println("该" + chessDesc + "下棋了； 例： 9  4");

            //横坐标
            int x = sc.nextInt();
            //纵坐标
            int y = sc.nextInt();
            if (x < 0 || y < 0 || x > 16 || y > 16) {
                System.out.println("该位置超出棋盘范围，请重新下棋。");
                continue;
            }else{
                // 如果是空棋可下棋
                if (boardArr[x][y] == CHESS_EMPTY) {
                    char chess = chessFlag ? CHESS_BLACK: CHESS_WHITE;
                    boardArr[x][y] = chess;
                    showBoard();
                    // 检测是否赢棋
                    if(checkResult(x, y, chess)){
                        System.out.println("恭喜" + chessDesc + "，赢得此局。");
                        break;
                    }
                    chessFlag = !chessFlag;
                } else {
                    System.out.println("该位置已有棋子，请重新下棋。");
                    continue;
                }
            }

        }
        sc.close();
    }

    /**
     * 判断输赢结果
     * @param x
     * @param y
     * @param chess
     * @return
     */
    public boolean checkResult(int x, int y, char chess){
        // 行连续相同棋子数
        int rowsCount = 0;
        // 列连续相同棋子数
        int colsCount = 0;
        // 左上到右下连续相同棋子数
        int tl2brCount = 0;
        // 左下到右上列连续相同棋子数
        int bl2trCount = 0;
        int copy_x = x;
        int copy_y = y;

        /* 判断行 */
        while(true){
            if (chess == boardArr[copy_x][copy_y]) {
                rowsCount++;
                if (copy_y == 0) {
                    break;
                }else{
                    copy_y--;
                }
            } else {
                break;
            }
        }

        copy_x = x;
        copy_y = y;
        while(true){
            if (chess == boardArr[copy_x][copy_y]) {
                rowsCount++;
                if (copy_y == cols-1) {
                    break;
                }else{
                    copy_y++;
                }
            } else {
                break;
            }
        }
        if(rowsCount > 5) return true;

        /* 判断列 */
        copy_x = x;
        copy_y = y;
        while(true){
            if (chess == boardArr[copy_x][copy_y]) {
                colsCount++;
                if (copy_x == 0) {
                    break;
                }else{
                    copy_x--;
                }
            } else {
                break;
            }
        }

        copy_x = x;
        copy_y = y;
        while(true){
            if (chess == boardArr[copy_x][copy_y]) {
                colsCount++;
                if (copy_x == rows-1) {
                    break;
                }else{
                    copy_x++;
                }
            } else {
                break;
            }
        }
        if(colsCount > 5) return true;

        /* 左上到右下 */
        copy_x = x;
        copy_y = y;
        while (true) {
            if (chess == boardArr[copy_x][copy_y]) {
                tl2brCount++;
                if (copy_x == 0 || copy_y == 0) {
                    break;
                }else{
                    copy_x--;
                    copy_y--;
                }
            } else {
                break;
            }
        }
        copy_x = x;
        copy_y = y;
        while (true) {
            if (chess == boardArr[copy_x][copy_y]) {
                tl2brCount++;
                if (copy_x == (rows - 1) || copy_y == (cols - 1)) {
                    break;
                }else{
                    copy_x++;
                    copy_y++;
                }
            } else {
                break;
            }
        }
        if(tl2brCount > 5) return true;

        /* 左下到右上 */
        copy_x = x;
        copy_y = y;
        while (true) {
            if (chess == boardArr[copy_x][copy_y]) {
                bl2trCount++;
                if (copy_x == 0 || copy_y == (cols - 1)) {
                    break;
                }else{
                    copy_x--;
                    copy_y++;
                }
            } else {
                break;
            }
        }
        copy_x = x;
        copy_y = y;
        while (true) {
            if (chess == boardArr[copy_x][copy_y]) {
                bl2trCount++;
                if (copy_x == (rows - 1) || copy_y == 0) {
                    break;
                }else{
                    copy_x++;
                    copy_y--;
                }
            } else {
                break;
            }
        }
        if(bl2trCount > 5) return true;
        return false;
    }


    /**
     * 打印棋盘
     */
    public void showBoard() {
        for(int i=0; i<boardArr.length; i++){
            for(int j=0; j<boardArr[i].length; j++){
                System.out.print(boardArr[i][j]);
                if(j != boardArr[i].length - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
