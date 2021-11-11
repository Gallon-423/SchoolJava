package exe7_3.persistence;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Gallon
 * @ClassName Student
 * @Package exe6_2.persistence
 * @Description 为提高查询效率在每一个学生对象类添加一个课程容器，采用hashmap()
 * 后续学生选择课程时添加在该容器添加课程，同样在课程中添加学生。
 * @Time 2021-11-11,周四 14:18
 */

public class Student {
    private String no;
    private String name;
    private int age;
    private boolean gender;

    HashMap<String, Course> coursesChosen;
    HashMap<String,Double> scores;
    public Student(String no, String name, int age, boolean gender) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.gender = gender;
        coursesChosen=new HashMap<>();
        scores=new HashMap<>();
    }
    public void choose(Course course){
        coursesChosen.put(course.getNo(),course);
        scores.put(course.getNo(), -1.404);
        //将所有成绩的初值设置为-1.404。
    }
    public Student() {
    }

    public HashMap<String, Course> getCoursesChosen() {
        return coursesChosen;
    }

    public void setCoursesChosen(HashMap<String, Course> coursesChosen) {
        this.coursesChosen = coursesChosen;
    }

    public HashMap<String, Double> getScores() {
        return scores;
    }

    public void setScores(HashMap<String, Double >scores) {
        this.scores = scores;
    }

    public void showAllScore(){
        System.out.println("如下：");
        for (Map.Entry<String, Double> entry : scores.entrySet()) {
            Double args = entry.getValue();
            String no=entry.getKey();
            Course c=coursesChosen.get(no);
            System.out.println(c.toString()+" "+args);
        }
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        String gen;
        if (gender) gen = "男";
        else gen = "女";
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gen +
                '}';
    }
}
