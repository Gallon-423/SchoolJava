package exe4_2.business;

import java.util.Objects;

public class Course {
    String no;
    String name;
    double grade;

    public Course(String no, String name, double grade) {
        this.no = no;
        this.name = name;
        this.grade = grade;
    }

    public Course() {
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
