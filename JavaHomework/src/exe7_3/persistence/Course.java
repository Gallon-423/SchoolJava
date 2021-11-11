package exe7_3.persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Course {
    String no;
    String name;
    double grade;
    HashMap<String, Student> studentsInCourse;
    public Course(String no, String name, double grade) {
        this.no = no;
        this.name = name;
        this.grade = grade;
        studentsInCourse=new HashMap<>();
    }

    public Course() {
        studentsInCourse=new HashMap<>();
    }
    public void takeIn(Student student){
        studentsInCourse.put(student.getNo(),student);
    }
    public void showAllStudents(){
        for (Map.Entry<String, Student> entry : studentsInCourse.entrySet()) {
            Student args = entry.getValue();
            String no=entry.getKey();
            Student student=studentsInCourse.get(no);
            System.out.println(student);
        }

    }
    public void chosen(Student student){
        studentsInCourse.put(student.getNo(),student);

    }
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public HashMap<String, Student> getStudentsInCourse() {
        return studentsInCourse;
    }

    public void setStudentsInCourse(HashMap<String, Student> studentsInCourse) {
        this.studentsInCourse = studentsInCourse;
    }

    @Override
    public String toString() {
        return "课程信息：" +
                "课程号为'" + no + '\'' +
                ", 课程名为'" + name + '\'' +
                ", 学分为" + grade +
                "分";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(no, course.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
