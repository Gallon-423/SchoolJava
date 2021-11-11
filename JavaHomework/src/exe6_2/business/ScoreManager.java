package exe6_2.business;

import exe6_2.persistence.Course;
import exe6_2.persistence.Student;

public class ScoreManager {
    private StudentManager sm;
    private CourseManager cm;
    public ScoreManager() {
    }
    public void judge(String sNo,String cNo,int x){
        /**
         * @Name judge
         * @Params [sNo, cNo, x]
         * @Types  [java.lang.String, java.lang.String, int]
         * @Return void
        */
        //为学生评分
        Student student=sm.search(sNo);
        student.getScores().replace(cNo,x);

    }
    public void studentChooseCourse(String sNo,String cNo) throws Exception {
        sm.search(sNo).getCoursesChosen().put(cNo,cm.search(cNo));
        cm.search(cNo).getStudentsInCourse().put(sNo,sm.search(sNo));
    }
    public void addStudent(String no,String name,int age,boolean gender){
        sm.add(no,name,age,gender);
    }
    public void deleteStudent(String no){
        sm.delete(no);
    }
    public void addCourse(String no,String name,int grade){
        cm.add(no,name,grade);
    }
    public void deleteCourse(String no){
        cm.delete(no);
    }

}
