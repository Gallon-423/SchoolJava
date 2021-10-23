package exe4_1.business;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String no;
    private String name;
    private int age;
    private boolean gender;

    public Student(String no, String name, int age, boolean gender) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Student() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return this.no.equals(student.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }


    @Override
    public int compareTo(Student o) {

        return (Long.parseLong(this.no)-Long.parseLong(o.no)>0)?1:-1;
    }
}
