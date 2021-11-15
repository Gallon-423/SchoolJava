package exe7_3.ui;

import exe7_3.business.ScoreManager;
import exe7_3.persistence.Course;
import exe7_3.persistence.Student;

import java.io.*;
import java.util.Scanner;

public class Ui {
    public static void go() throws Exception {
        ScoreManager scoreManager=new ScoreManager();
        Scanner sc=new Scanner(System.in);
        int step;
        do {
            System.out.println("请输入数字以进行选择：");
            System.out.println("1、学生选课程；");
            System.out.println("2、给学生某门课程评分；");
            System.out.println("3、查询学生所有课程成绩：");
            System.out.println("4、增添学生；");
            System.out.println("5、增添课程；");
            System.out.println("6、查询某课程所有学生");
            System.out.println("0、退出");
            step=sc.nextInt();
            switch (step){
                case 0:
                    break;
                case 1:
                    System.out.println("请输入学生学号：");
                    String no1=sc.next();
                    System.out.println("请输入课程号：");
                    String no2=sc.next();
                    scoreManager.studentChooseCourse(no1,no2);
                    break;
                case 2:
                    System.out.println("请输入学生学号：");
                    String no3=sc.next();
                    System.out.println("请输入课程号：");
                    String no4=sc.next();
                    System.out.println("请输入课程成绩：");
                    double x=sc.nextDouble();
                    scoreManager.judge(no3,no4,x);
                    break;
                case 3:
                    System.out.println("请输入学生学号：");
                    String no5=sc.next();
                    scoreManager.getSm().search(no5).showAllScore();
                    break;
                case 4:
                    System.out.println("请输入学生学号：");
                    String no6=sc.next();
                    System.out.println("请输入学生名：");
                    String name1=sc.next();
                    System.out.println("请输入学生年龄：");
                    int age=sc.nextInt();
                    System.out.println("请输入学生性别(0为男，1为女)");
                    int gender=sc.nextInt();
                    boolean gen= gender==0;
                    scoreManager.addStudent(no6,name1,age,gen);
                    break;
                case 5:
                    System.out.println("输入课程号:");
                    String no7=sc.next();
                    System.out.println("请输入课程名：");
                    String name2=sc.next();
                    System.out.println("请输入课程学分：");
                    int grade=sc.nextInt();
                    scoreManager.addCourse(no7,name2,grade);
                    break;
                case 6:
                    System.out.println("请输入课程号：");
                    String no8=sc.next();
                    scoreManager.getCm().search(no8).showAllStudents();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + step);
            }

        }
        while(step!=0);


        String target1="student_data.txt";
        String target2="course_data.txt";
        String target3="course_selection_data.txt";

        File f1=new File(target1);
        File f2=new File(target2);
        File f3=new File(target3);

        String a1= "学号    姓名      年龄      性别      \n";
        FileWriter writer1 = new FileWriter(target1);
        for(Student s:scoreManager.getSm().getStudents().values()){
            char gen=s.isGender()?'男':'女';
            String name= String.format("%-8s",s.getName());
            String no= String.format("%-10s",s.getNo());
            String age=String.format("%-8d",s.getAge());
            a1+= name+no+age+gen+'\n';
            //要求学号长度相等才能对齐。
        }
        writer1.write("");//清空原文件内容
        writer1.write(a1);
        writer1.flush();
        writer1.close();

        a1="课程号     课程名称    学分    \n";
        FileWriter writer2 = new FileWriter(target2);
        for(Course course:scoreManager.getCm().getCourses().values()){
            String name= String.format("%-10s",course.getName());
            String no= String.format("%-10s",course.getNo());
            String grade=String.format("%-8.1f",course.getGrade());
            a1+= no+name+grade+'\n';
            //要求课程号长度相等才能对齐。
        }
        writer2.write("");//清空原文件内容
        writer2.write(a1);
        writer2.flush();
        writer2.close();

        a1="学号      课程号     成绩    \n";
        FileWriter writer3 = new FileWriter(target3);
        for(Student s:scoreManager.getSm().getStudents().values()){
            for (String no:s.getScores().keySet()
                 ) {
                String sno= String.format("%-10s",s.getNo() );
                String cno=String.format("%-10s",no );
                String score=String.format("%-8f",s.getScores().get(no));
                a1+=sno+cno+score+'\n';
            }
        }
        writer3.write("");//清空原文件内容
        writer3.write(a1);
        writer3.flush();
        writer3.close();







    }
}
