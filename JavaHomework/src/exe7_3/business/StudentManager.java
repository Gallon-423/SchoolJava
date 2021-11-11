package exe7_3.business;


import exe7_3.persistence.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private HashMap<String, Student> students;

    public StudentManager() {
        this.students = new HashMap<>();
    }

    public Student search(String no){
        return students.get(no);
    }
    public void add(Student student){
        students.put(student.getNo(),student);
    }
    public void add(String no,String name,int age,boolean gender){
        Student student=new Student(no,name,age,gender);
        students.put(student.getNo(),student);
    }
    public void delete(Student student){
        students.remove(student.getNo());
    }
    public void delete(String no){
        students.remove(no);
    }
    public void show(){
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            Student args = entry.getValue();
            System.out.println(args);
        }
    }


}
