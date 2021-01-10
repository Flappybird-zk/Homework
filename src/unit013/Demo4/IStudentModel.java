package unit013.Demo4;

import java.util.ArrayList;

public interface IStudentModel {
    boolean add(Student stu);
    Student delById(String id);
    int delByName(String name);
    int delByAge(int age);
    Student modifyById(String id, Student stu);
    Student findById(String id);
    ArrayList<Student> findByName(String name);
    ArrayList<Student> findByAge(int age);
    void showAll();
}
