import java.util.Scanner;

public class Exe2_4 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner sc=new Scanner(System.in);
        String target=sc.next();
        if(judge(target)){
            System.out.println("是回文整数");
        }else{
            System.out.println("不是回文整数");
        }
    }

    public static boolean judge(String str){
        char[] a=str.toCharArray();
        boolean bool=true;
        for (int i = 0; i < a.length/2; i++) {
            if(a[i]!=a[a.length-i-1]){
                bool=false;
            }

        }
        return bool;
    }
}
