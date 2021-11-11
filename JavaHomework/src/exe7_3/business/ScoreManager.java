package exe7_3.business;

import exe7_3.persistence.Student;

public class ScoreManager {
    private StudentManager sm;
    private CourseManager cm;
    public ScoreManager() {
        sm=new StudentManager();
        cm=new CourseManager();
    }
    public void judge(String sNo,String cNo,Double x){
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

    public StudentManager getSm() {
        return sm;
    }

    public void setSm(StudentManager sm) {
        this.sm = sm;
    }

    public CourseManager getCm() {
        return cm;
    }

    public void setCm(CourseManager cm) {
        this.cm = cm;
    }

    public void studentChooseCourse(String sNo, String cNo) throws Exception {
        sm.search(sNo).choose(cm.search(cNo));
        cm.search(cNo).chosen(sm.search(sNo));
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
