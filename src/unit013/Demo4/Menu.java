package unit013.Demo4;

public class Menu {
    public static void showMainMenu(){
        System.out.println("\n主菜单");
        System.out.println("=============================");
        System.out.println("    1   增加");
        System.out.println("    2   删除");
        System.out.println("    3   修改");
        System.out.println("    4   查询");
        System.out.println("    5   查看所有学生信息");
        System.out.println("    0   退出");
        System.out.println("=============================");
    }

    public static void showFindMenu(){
        System.out.println("\n查询菜单");
        System.out.println("=============================");
        System.out.println("        1   根据id查询");
        System.out.println("        2   根据name查询");
        System.out.println("        3   根据age查询");
        System.out.println("        0   退出");
        System.out.println("=============================");
    }

    public static void showModifyMenu(){
        System.out.println("\n修改菜单");
        System.out.println("=============================");
        System.out.println("        1   修改姓名");
        System.out.println("        2   修改年龄");
        System.out.println("        3   保存");
        System.out.println("        0   退出");
        System.out.println("=============================");
    }

    public static void showDelMenu(){
        System.out.println("\n删除菜单");
        System.out.println("=============================");
        System.out.println("        1   输入学号删除");
        System.out.println("        2   确认删除");
        System.out.println("        0   退出");
        System.out.println("=============================");
    }
}
