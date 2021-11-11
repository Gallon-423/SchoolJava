package exe7_3.business;



import exe7_3.persistence.Course;

import java.util.HashMap;
import java.util.Map;


public class CourseManager {
    HashMap<String, Course> courses;
    public CourseManager(){
        this.courses=new HashMap<>();
    }
    public void add(Course course){
        courses.put(course.getNo(),course);
        System.out.println("添加成功");
    }
    public void add(String no,String name,int grade){
        Course course=new Course(no,name,grade);
        add(course);
    }
    public void delete(String no){
        courses.remove(no);
    }
    public void delete(Course course){
        courses.remove(course.getNo());
    }
    public Course search(String no) throws Exception {
        if(!courses.containsKey(no)) throw new Exception("课程号不存在，执行错误，查询失败");
        else return courses.get(no);
    }

    public HashMap<String, Course> getCourses() {
        return courses;
    }

    public void setCourses(HashMap<String, Course> courses) {
        this.courses = courses;
    }

    public void show(){
        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            Course args = entry.getValue();
            System.out.println(args);
        }
    }

}
