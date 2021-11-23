package exe6_1;


import java.util.Objects;
import java.util.Random;

/**
 * @Author Gallon
 * @ClassName Test
 * @Package Exe6_1.ui
 * @Description  为了简化打印，添加学生成功时不显示“添加成功”；查询同,输出一个数字0（不换行）表示查询成功。
 * @Time 2021-11-09,周二 14:54
 */

public class Test {

    public static void main(String[] args)  {
        testArraylist();
        testTreeSet();
        testLinkedList();
        testHashMap();
        Student s=new Student();
        System.out.println(Objects.hash(s));
        Student s2=new Student();
        System.out.println(Objects.hash(s2));
    }

    public static void testArraylist(){
        StudentManager_ArrayList sa=new StudentManager_ArrayList();

        String[] nos=new String[1000];
        for (int i=0;i<1000;i++){
            Random random=new Random();
            nos[i]=Long.toString(random.nextLong());
        }
        long t1=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            String name="0"+i;
            Random random=new Random();
            int age=random.nextInt(100);
            boolean gender=random.nextBoolean();
            sa.addStudent(nos[i],name,age,gender);
        }
        long t2=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            sa.search(nos[i]);
        }
        long t3=System.currentTimeMillis();
        long t=System.nanoTime();
        for (int i = 0; i < 100; i++) {
            sa.deleteStudent(nos[i]);
        }
        long t4=System.currentTimeMillis();
        System.out.println();
        System.out.println("使用ArrayList的方案：");
        System.out.println("添加1000次时间："+(t2-t1)+"ms");
        System.out.println("查询100次时间："+(t3-t2)+"ms");
        System.out.println("删除100次时间："+(t4-t3)+"ms");
    }


    public static void testTreeSet(){
        StudentManager_TreeSet st=new StudentManager_TreeSet();

        String[] nos=new String[1000];
        for (int i=0;i<1000;i++){
            Random random=new Random();
            nos[i]=Long.toString(random.nextLong());
        }
        long t1=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            String name="00"+i;
            Random random=new Random();
            int age=random.nextInt(100);
            boolean gender=random.nextBoolean();
            st.addStudent(nos[i],name,age,gender);
        }
        long t2=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            st.search(nos[i]);
        }
        long t3=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            st.deleteStudent(nos[i]);
        }
        long t4=System.currentTimeMillis();
        System.out.println();
        System.out.println("使用TreeSet的方案：");
        System.out.println("添加1000次时间："+(t2-t1)+"ms");
        System.out.println("查询100次时间："+(t3-t2)+"ms");
        System.out.println("删除100次时间："+(t4-t3)+"ms");
    }

    public static void testLinkedList(){
        StudentManager_LinkedList sl=new StudentManager_LinkedList();

        String[] nos=new String[1000];
        for (int i=0;i<1000;i++){
            Random random=new Random();
            nos[i]=Long.toString(random.nextLong());
        }
        long t1=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            String name="00"+i;
            Random random=new Random();
            int age=random.nextInt(100);
            boolean gender=random.nextBoolean();
            sl.addStudent(nos[i],name,age,gender);
        }
        long t2=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            sl.search(nos[i]);
        }
        long t3=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            sl.deleteStudent(nos[i]);
        }
        long t4=System.currentTimeMillis();
        System.out.println();
        System.out.println("使用LinkedList的方案：");
        System.out.println("添加1000次时间："+(t2-t1)+"ms");
        System.out.println("查询100次时间："+(t3-t2)+"ms");
        System.out.println("删除100次时间："+(t4-t3)+"ms");
    }

    public static void testHashMap(){
        StudentManager_HashMap sh=new StudentManager_HashMap();

        String[] nos=new String[1000];
        for (int i=0;i<1000;i++){
            Random random=new Random();
            nos[i]=Long.toString(random.nextLong());
        }
        long t1=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            String name="00"+i;
            Random random=new Random();
            int age=random.nextInt(100);
            boolean gender=random.nextBoolean();
            sh.addStudent(nos[i],name,age,gender);
        }
        long t2=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            sh.search(nos[i]);
        }
        long t3=System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            sh.deleteStudent(nos[i]);
        }
        long t4=System.currentTimeMillis();
        System.out.println();
        System.out.println("使用HashMap的方案：");
        System.out.println("添加1000次时间："+(t2-t1)+"ms");
        System.out.println("查询100次时间："+(t3-t2)+"ms");
        System.out.println("删除100次时间："+(t4-t3)+"ms");
    }



}
