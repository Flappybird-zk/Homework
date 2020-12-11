package unit3.Demo4;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {

    public void start(){
        Scanner sc = new Scanner(System.in);
        StudentModel stuModel = new StudentModel();
        while(true){
            Menu.showMainMenu();
            System.out.println("请输入操作编号:");
            int menu = sc.nextInt();
            boolean loop = false;
            switch(menu){
                case 0:
                    loop = true;
                    break;
                case 1:
                    System.out.println("输入学号：");
                    String id = sc.next();
                    System.out.println("输入姓名：");
                    String name = sc.next();
                    System.out.println("输入年龄：");
                    int age = sc.nextInt();
                    boolean res = stuModel.add(new Student (id, name, age));
                    if(res){
                        System.out.println("添加成功.");
                    }else{
                        System.out.println("添加失败！");
                    }
                    break;
                case 2:
                    boolean delBreak = false;
                    String delId = "";
                    while(true){
                        Menu.showDelMenu();
                        int delMenu = sc.nextInt();
                        switch(delMenu){
                            case 0:
                                delBreak = true;
                                break;
                            case 1:
                                System.out.println("请输入需要删除的学号：");
                                delId = sc.next();
                                Student delStu = stuModel.findById(delId);
                                if(delStu == null){
                                    System.out.println("该用户不存在!!!");
                                }else{
                                    System.out.println("学号为" + delId + "信息为" + delStu + "下一步请确认删除->");
                                }
                                break;
                            case 2:
                                if(delId != ""){
                                    Student delStuRes = stuModel.delById(delId);
                                    if(delStuRes == null){
                                        System.out.println("删除失败！！！");
                                    }else{
                                        System.out.println("删除成功。");
                                    }
                                }else{
                                    System.out.println("数据异常。");
                                }
                                break;
                            default:
                                showErrorTip();
                                break;

                        }
                        if(delBreak){
                            System.out.println("已退出删除操作。");
                            break;
                        }
                    }
                    break;
                case 3:
                    while(true){
                        System.out.println("请输入学号进行修改");
                        String modifyId = sc.next();
                        Student modifyStu = stuModel.findById(modifyId);
                        if(modifyStu == null){
                            System.out.println("该用户不存在!!!");
                        }else{
                            System.out.println("学号为" + modifyId + "信息为" + modifyStu);
                            boolean modifyBreak = false;
                            String modifyName="";
                            int modifyAge = -1;
                            while(true){
                                Menu.showModifyMenu();
                                int modifyMenu = sc.nextInt();
                                switch(modifyMenu){
                                    case 0:
                                        modifyBreak = true;
                                        break;
                                    case 1:
                                        System.out.println("请输入要修改的姓名:");
                                        modifyName = sc.next();
                                        break;
                                    case 2:
                                        System.out.println("请输入要修改的年龄:");
                                        modifyAge = sc.nextInt();
                                        break;
                                    case 3:
                                        System.out.println("name=" + modifyName + ", age=" + modifyAge);
                                        if(!(modifyStu.getName().equals(modifyName)) && modifyName != ""){
                                            modifyStu.setName(modifyName);
                                        }
                                        if(!(modifyStu.getAge() == modifyAge) && modifyAge >= 0){
                                            modifyStu.setAge(modifyAge);
                                        }
                                        Student modifyStuRes = stuModel.modifyById(modifyId, modifyStu);
                                        if(modifyStuRes == null){
                                            System.out.println("保存失败！！！");
                                        }else{
                                            System.out.println("保存成功, 信息更新为："+ modifyStuRes);
                                        }
                                        break;
                                    default:
                                        showErrorTip();
                                        break;
                                }
                                if(modifyBreak){
                                    System.out.println("已退出修改操作。");
                                    break;
                                }
                            }
                            break;
                        }
                    }

                    break;
                case 4:
                    boolean findLoop = false;
                    while(true){
                        Menu.showFindMenu();
                        int findMenu = sc.nextInt();
                        switch(findMenu){
                            case 0:
                                findLoop = true;
                                break;
                            case 1:
                                System.out.println("请输入id查找:");
                                String findId = sc.next();
                                Student stu = stuModel.findById(findId);
                                System.out.println("根据id=" + findId + "查询到的信息：" + stu);
                                break;
                            case 2:
                                System.out.println("请输入姓名查找:");
                                String findName = sc.next();
                                ArrayList<Student> stuListByName = stuModel.findByName(findName);
                                System.out.println("根据name=" + findName + "查询到的信息：");
                                showStudentList(stuListByName);
                                break;
                            case 3:
                                System.out.println("请输入年龄查找:");
                                int findAge = sc.nextInt();
                                ArrayList<Student> stuListByAge = stuModel.findByAge(findAge);
                                System.out.println("根据age=" + findAge + "查询到的信息：");
                                showStudentList(stuListByAge);
                                break;
                            default:
                                showErrorTip();
                                break;
                        }
                        if(findLoop){
                            System.out.println("退出查找操作");
                            break;
                        }
                    }
                    break;
                case 5:
                    // 展示所有学生信息
                    stuModel.showAll();
                    break;
                default:
                    showErrorTip();
                    break;
            }
            if(loop){
                sc.close();
                System.out.println("您已退出操作。");
                break;
            }
        }
    }

    public void showErrorTip(){
        System.out.println("请重新输入正确的操作！！！");
    }

    public void showStudentList(ArrayList<Student> stuList){
        if(stuList.size() > 0){
            for(Student s: stuList){
                System.out.println(s);
            }
        }else{
            System.out.println("没有查询到学生信息！！！");
        }

    }
}
