import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * @Author Gallon
 * @ClassName Exe7_1
 * @Description 复制文件到除后缀以外同名的文件中
 * @Time 2021-11-11,周四 18:32
 */

public class Exe7_1 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String originPath=sc.next();
        File ori=new File(originPath);
        if(!ori.exists()) throw new Exception("文件不存在！你必须给出一个已存在的源文件用于复制！");
        String oriName=ori.getAbsolutePath();
        //注意此处要是有获取绝对路径的方法，否则只返回文件名字。
        String tarName=oriName.substring(0,oriName.length()-4);
        tarName += ".bak";
        //System.out.println(tarName);
        File tar=new File(tarName);

        if(!tar.exists()) {
            tar.createNewFile();
        }
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(ori).getChannel();
            outputChannel = new FileOutputStream(tar).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }

    }
}
