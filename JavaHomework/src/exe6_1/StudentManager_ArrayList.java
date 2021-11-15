package exe6_1;

import java.util.ArrayList;

public class StudentManager_ArrayList {
    private ArrayList<Student> students;

    public StudentManager_ArrayList() {
        students=new ArrayList<>();
       // System.out.println("一个新对象出现了~");
    }
    public void addStudent(String no, String name, int age, boolean gender) {
        Student newStudent=new Student(no,name,age,gender);
        for (Student student:students
        ) {
            if(student.getNo().equals(no)){
                //System.out.println("输入学号已被使用！");
                return;
            }

        }

        students.add(newStudent);

        //System.out.println("增加学生成功");
    }


    public void deleteStudent(String noString){
        students.removeIf(student -> student.getNo().equals(noString));
        if(students.isEmpty()){
            System.out.println("当前系统无学生信息！");
        }
    }

    public void search(String no) {
        students.forEach(o->{if(o.getNo().equals(no)) System.out.print(0);});
    }


}
