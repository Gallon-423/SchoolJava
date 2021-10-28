import java.util.Arrays;
import java.util.Scanner;

public class Exe5_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println("输入句子的单词数为："+wordCount(str));
        System.out.println(str);

        //以下为更简便实现方法，未提交至邮箱，没必要
        String[] s=str.split(" ");
        int count=0;
        for (String a:s
             ) {
            if(a.matches("^[A-Z.a-z]+$"))
            count++;

        }
        System.out.println("输入句子的单词数为："+count);
    }
    static int wordCount(String str){
        char[] chars=str.toCharArray();
        boolean hasMeetedWord=false;
        int spaceCount=0;
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i]>'z'||chars[i]<'a') && (chars[i]>'Z'||chars[i]<'A')&&chars[i]!=' ' )
                continue;
            if(!hasMeetedWord && chars[i]!=' '){
                hasMeetedWord=true;
                continue;
            }
            if(hasMeetedWord && chars[i]==' '){
                spaceCount++;
                //System.out.println("Changed");
                if(i+1>=chars.length){
                    spaceCount--;
                    continue;
                }
                if((chars[i+1]>'z'||chars[i+1]<'a') && (chars[i+1]>'Z'||chars[i+1]<'A') ){
                    spaceCount--;
                }
            }
        }
        return spaceCount+1;
    }
}
