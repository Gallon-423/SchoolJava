import java.util.Scanner;
public class Ui {
    static public void go(){
        ResourceAllocator resourceAllocator=new ResourceAllocator();
        showMsg();
        Scanner sc=new Scanner(System.in);
        int step=sc.nextInt();
        while(step!=0){
            switch (step){
                case 1:
                    while(step!=0){
                    System.out.println("输入分区起始地址：");
                    int begin=sc.nextInt();
                    System.out.println("输入分区结束地址：");
                    int end= sc.nextInt();
                    Partition p=new Partition(begin,end);
                    resourceAllocator.add(p);
                    System.out.println("输入数字选择步骤：");
                    System.out.println("0结束添加");
                    System.out.println("1继续添加");
                    step=sc.nextInt();
                    }
                    step=1;
                    break;
                case 2:
                    System.out.println("输入作业号：");
                    String name=sc.next();
                    System.out.println("输入作业所需分区长度：");
                    int len=sc.nextInt();
                    Task task=new Task(len,name);
                    System.out.println("请输入要选择的适应算法：");
                    System.out.println("1最先适应算法");
                    System.out.println("2最佳适应算法");
                    System.out.println("3最差适应算法");
                    int step2=sc.nextInt();
                    switch (step2){
                        case 1:resourceAllocator.firstFit(task);break;
                        case 2:resourceAllocator.bestFit(task);break;
                        case 3:resourceAllocator.worstFit(task);break;
                    }
                    break;
                case 3:
                    System.out.println("请输入你要回收的作业号：");
                    String name1=sc.next();
                    resourceAllocator.recycle(name1);
                    break;
                case 4:
                    resourceAllocator.show();
            }
            showMsg();
            step=sc.nextInt();
        }
    }

    static public void showMsg(){
        System.out.println("输入数字选择步骤：");
        System.out.println("0退出程序");
        System.out.println("1添加分区");
        System.out.println("2添加作业请求");
        System.out.println("3回收分区");
        System.out.println("4展示当前分配情况");
    }
}
