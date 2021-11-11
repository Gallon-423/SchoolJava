package exe6_2.ui;

import exe6_2.business.ScoreManager;

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
            }
        }
        while(step!=0);
    }
}
