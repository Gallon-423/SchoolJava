package exe4_1.ui;

import exe4_1.persistence.StudentManager;

import java.util.Scanner;

public class Test {

    public static void main(String[] args)  {
        StudentManager studentManager=new StudentManager();
        go(studentManager);
    }

    static void go(StudentManager studentManager)  {
//        System.out.println("请根据下列信息输入数字：");
//        System.out.println("1:输入学生信息，加入学生");
//        System.out.println("2:输入学生学号，删除学生");
//        System.out.println("3:展示当前所有学生信息");
//        System.out.println("4:结束操作");
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("请根据下列信息输入数字：");
            System.out.println("1:输入学生信息，加入学生");
            System.out.println("2:输入学生学号，删除学生");
            System.out.println("3:展示当前所有学生信息");
            System.out.println("4:结束操作");
            int mark=sc.nextInt();

            if(mark==1){
                System.out.println("请按照学号、姓名、年龄、性别（1代表男，0代表女），以空格间隔输入：");
                String no=sc.next();
                String name=sc.next();
                int age=sc.nextInt();
                int gen=sc.nextInt();

                if(gen!=1&&gen!=0) {
                    System.out.println("输入性别有错误,请进行下一轮操作");
                    continue;
                }
                boolean gender= gen == 1;
                studentManager.addStudent(no,name,age,gender);
            }else if(mark==2){
                String no=sc.next();
                studentManager.deleteStudent(no);

            }else if(mark==3){
                studentManager.showStudents();
            }else if(mark==4){
                System.out.println("操作结束");
                break;
            }
            System.out.println("请在输入相关操作对应的数字：");
        }
    }
}
