package exe4_2;

import exe4_2.business.Course;
import exe4_2.persistence.CourseManager;
import exe4_2.ui.Ui;

public class Test {
    public static void main(String[] args) {
        Course c1=new Course("10001","物理（上）",3.5);
        Course c2=new Course("10002","物理（下）",3.5);
        Course c3=new Course("10005","物理试验",5);
        CourseManager cm=new CourseManager();
        cm.addCourse(c1);
        cm.addCourse(c2);
        cm.addCourse(c3);
        Ui.go(cm);
    }
}
