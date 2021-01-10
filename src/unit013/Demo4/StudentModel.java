package unit013.Demo4;

import java.util.ArrayList;
import java.util.List;

public class StudentModel implements IStudentModel {
    private List<Student> stuList = new ArrayList<>();

    @Override
    public boolean add(Student stu) {
        Student res = this.findById(stu.getId());
        if(res == null){
            stuList.add(stu);
            return true;
        }
        return false;
    }

    @Override
    public Student delById(String id) {
        for(int idx=0; idx<stuList.size(); idx++){
            if(stuList.get(idx).getId().equals(id)){
                Student returnStu = stuList.remove(idx);
                return returnStu;
            }
        }
        return null;
    }

    @Override
    public int delByName(String name) {
        return 0;
    }

    @Override
    public int delByAge(int age) {
        return 0;
    }

    @Override
    public Student modifyById(String id, Student stu) {
        for(int idx=0; idx<stuList.size(); idx++){
            if(stuList.get(idx).getId().equals(id)){
                Student returnStu = stuList.set(idx, stu);
                return returnStu;
            }
        }
        return null;
    }

    @Override
    public Student findById(String id) {
        for(Student s: stuList){
            if(id.equals(s.getId())){
                return s;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> findByName(String name) {
        ArrayList<Student> returnStuList = new ArrayList<>();
        for(Student s: stuList){
            if(name.equals(s.getName())){
                returnStuList.add(s);
            }
        }
        return returnStuList;
    }

    @Override
    public ArrayList<Student> findByAge(int age) {
        ArrayList<Student> returnStuList = new ArrayList<>();
        for(Student s: stuList){
            if(age == s.getAge()){
                returnStuList.add(s);
            }
        }
        return returnStuList;
    }

    @Override
    public void showAll() {
        if(stuList.size() > 0){
            for(Student s: stuList){
                System.out.println(s);
            }
        }else{
            System.out.println("无学生记录。");
        }

    }

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }
}
