package unit014.demo1;

import java.io.Serializable;

/**
 * 编程实现学生类的封装，实现序列化接口
 */
public class Student implements Serializable {
	// 序列化版本号
	private static final long serialVersionUID = 1234567890L;

	private int id;      // 用于描述学号的成员变量
	private String name; // 用于描述姓名的成员变量
	private int age;     // 用于描述年龄的成员变量
	
	public Student() {
		super();
	}
	public Student(int id, String name, int age) throws AgeException, IdException{
		super();
		setId(id);
		setName(name);
		setAge(age);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) throws IdException{
		if(id > 0){
			this.id = id;
		}
		else{
//			System.out.println("学号不合理哦！！！");
			throw new IdException("学号不合理哦！！！");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeException{
		if(age >= 4 && age <= 60){
			this.age = age;
		}
		else{
//			System.out.println("年龄不合理哦！！！");
			throw new AgeException("年龄不合理哦！！！");
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
