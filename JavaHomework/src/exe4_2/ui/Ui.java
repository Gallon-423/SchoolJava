package exe4_2.ui;

import exe4_2.persistence.CourseManager;

import java.util.Scanner;

public class Ui {
    public static void go(CourseManager cm){
        System.out.println("已进入课程系统，请根据所需操作输入数字：");
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("");
            System.out.println("1:根据课程号查询课程");
            System.out.println("2:根据课程名查询课程");
            System.out.println("3:根据课程学分查询课程");
            System.out.println("4:录入信息");
            System.out.println("5:根据课程号删除课程");
            System.out.println("6:修改课程信息");
            System.out.println("7:展示所有课程信息");
            System.out.println("8:结束操作");
            int step=sc.nextInt();
            switch (step){
                case 1:{
                    System.out.println("请输入待查询课程号：");
                    String no=sc.next();
                    cm.searchOnNo(no);
                    break;
                }
                case 2:{
                    System.out.println("请输入待查询课程名：");
                    String name=sc.next();
                    cm.searchOnName(name);
                    break;
                }
                case 3:{
                    System.out.println("请输入待查询课程学分：");
                    double grade=sc.nextDouble();
                    cm.searchOnGrade(grade);
                    break;
                }
                case 4: {
                    System.out.println("请输入待增加课程号：");
                    String no=sc.next();
                    if(cm.contains(no)){
                        System.out.println("该课程号已存在");
                        break;
                    }
                    System.out.println("请输入待增加课程名：");
                    String name=sc.next();
                    System.out.println("请输入待增加课程学分：");
                    double grade=sc.nextDouble();
                    cm.addCourse(no,name,grade);
                    break;}
                case 5:{
                    System.out.println("请输入待删除课程号：");
                    String no=sc.next();
                    cm.deleteCourse(no);
                    break;
                }
                case 6:{
                    System.out.println("请输入待修改课程号：");
                    String no=sc.next();
                    if(!cm.contains(no)){
                        System.out.println("该课程号不存在");
                        break;
                    }
                    System.out.println("请输入待修改课程号(修改后的课程号)：");
                    no=sc.next();
                    System.out.println("请输入待修改课程名（修改后的课程名）：");
                    String name=sc.next();
                    System.out.println("请输入待修改课程学分（修改后的学分）：");
                    double grade=sc.nextDouble();
                    cm.setCourses(no,name,grade);
                    break;
                }
                case 7:{
                    cm.show();
                    break;
                }
                case 8:{
                    return;
                }
            }
            System.out.println("请问是否继续操作？Y/N");
            String flag=sc.next();
            if (flag.equals("Y")){
                continue;
            }else if(flag.equals("N")){
                return;
            }
        }
    }
}
