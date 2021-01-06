package unit4.demo1;

/**
 * 编程实现学生信息管理系统中字符界面层的功能
 */
public class ViewStudent {
	/**
	 * 声明逻辑处理层类型的引用作为本类的成员变量，从而实现逻辑处理类方法的调用
	 */
	private ManageStudent ms;

	/**
	 * 通过构造方法实现成员变量的初始化
	 * @param ms
	 */
	public ViewStudent(ManageStudent ms){
		this.ms = ms;
	}

	/**
	 * 实现主菜单的绘制
	 */
	public void showMenu() throws AgeException, IdException {
		// 从文件中读取学生信息
		ms.readStudentsFromFile();

		while(true){
			System.out.println("\n\n\t       学生信息管理系统");
			System.out.println("-------------------------------------------");
			System.out.print("   [1] 增加学生信息");
			System.out.println("         [2] 删除学生信息");
			System.out.print("   [3] 修改学生信息");
			System.out.println("         [4] 查找学生信息");
			System.out.print("   [5] 显示学生信息");
			System.out.println("         [0] 退出学生系统");
			System.out.println("-------------------------------------------");
			System.out.println("请选择具体的业务编号:");
			int choose = ScannerStudent.getScanner().nextInt();
			
			switch(choose) {
				case 1: ms.addStudent(); break;
				case 2: ms.deleteStudent(); break;
				case 3: ms.modifyStudent(); break;
				case 4: ms.queryStudent(); break;
				case 5: ms.printStudent(); break;
				case 0:
					// 保存学生信息到文件
					ms.saveStudentsToFile();
					System.out.print("谢谢使用，再见！");
						return;
				default:System.out.println("输入错误，请重新输入");
			}
		}
	}
}
