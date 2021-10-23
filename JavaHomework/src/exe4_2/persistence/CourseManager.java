package exe4_2.persistence;

import exe4_2.business.Course;

import java.util.LinkedHashSet;

public class CourseManager {
    LinkedHashSet<Course> courses;

    public CourseManager() {
        courses=new LinkedHashSet<Course>();
    }

    public CourseManager(LinkedHashSet<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        courses.forEach(o->{
            if(course.getNo().equals(o.getNo())) {
                System.out.println("输入课程号重复，" + "已被使用");
            }
        });
        courses.add(course);
    }
    public void addCourse(String no, String name, double grade){
        courses.forEach(o->{
            if(no.equals(o.getNo())) {
                System.out.println("输入课程号重复，" + "已被使用");
            }
        });
        courses.add(new Course(no,name,grade));
    }
    public void deleteCourse(String no){
        courses.removeIf(o->o.getNo().equals(no));

        System.out.println("课程号为"+no+"的课程" +
                "已删除成功");
    }
    public void setCourses(String no,String name,double grade){
        courses.forEach(o->{if(o.getNo().equals(no))
        {
            o.setName(name);
            o.setGrade(grade);
        }
        });
    }
    public void searchOnNo(String no){
        System.out.println("以下根据课程号查找课程信息（若未打印则无符合信息）");
        courses.forEach(o->{if(o.getNo().equals(no))
        {
            System.out.println(o);
        }
        });

    }
    public void searchOnName(String name){
        System.out.println("以下根据课程名查找课程信息（若未打印则无符合信息）");
        courses.forEach(o->{if(o.getName().equals(name))
        {
            System.out.println(o);
        }
        });

    }

    public void searchOnGrade(double grade){
        System.out.println("以下根据课程学分查找课程信息（若未打印则无符合信息）");
        courses.forEach(o->{if(o.getGrade()==grade)
        {
            System.out.println(o);
        }
        });

    }

    public void show(){
        courses.forEach(System.out::println);
    }

    public boolean contains(String no){
        for (Course c:courses
             ) {
            if(c.getNo().equals(no)){
                return true;
            }

        }
        return false;
    }

}
