import java.io.File;
import java.util.Scanner;

/**
 * @Author Gallon
 * @ClassName Exe7_1
 * @Description  递归显示文件夹内所有文件以及子文件夹的名字
 * @Time 2021-11-11,周四 18:11
 */

public class Exe7_2 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String path = sc.next();
        File target=new File(path);
        if(!target.exists()) throw new Exception("目标文件夹不存在");
        if(target.isFile()) throw new Exception("目标为文件，不可递归");
        search(target);

    }
    static public void search(File target){
        if(target.isFile()) System.out.println(target.getName());
        else{
            System.out.println(target.getName());//文件夹的名字也要打印
            //递归打印的顺序类似于树遍历方法中的先序遍历。
            File[] files=target.listFiles();
            for (File file:files
                 ) {
                search(file);
            }
        }
    }
}
