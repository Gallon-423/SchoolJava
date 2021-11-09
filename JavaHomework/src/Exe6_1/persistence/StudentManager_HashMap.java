package Exe6_1.persistence;

import Exe6_1.business.Student;

import java.util.HashMap;
import java.util.LinkedList;

public class StudentManager_HashMap {
    private HashMap<String,Student> students;

    public StudentManager_HashMap() {
        students=new HashMap<>();
    }


    public void addStudent(String no, String name, int age, boolean gender) {
        Student newStudent=new Student(no,name,age,gender);
        students.put(newStudent.getNo(),newStudent);

        //System.out.println("增加学生成功");
    }

    public void deleteStudent(String noString){
        students.remove(noString);
        if(students.isEmpty()){
            System.out.println("当前系统无学生信息！");
        }
    }

    public void search(String no) {
        students.get(no);
        System.out.print("0");
    }
}
