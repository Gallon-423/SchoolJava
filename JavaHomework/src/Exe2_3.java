import java.util.Scanner;

public class Exe2_3 {
    public static void main(String[] args) {
        System.out.println("请输入一个四位数的年份：");
        Scanner sc=new Scanner(System.in);
        int target=sc.nextInt();
        if(judge(target)){
            System.out.println(target+"年是闰年");
        }else{
            System.out.println(target+"年不是闰年");
        }
    }
    /**
     * judge
     * @Param int target 四位数的年份
     * @Return boolean 返回是否为闰年
     */
    public static boolean judge(int target){
        if(target%4==0){
            if(target%100!=0){
                return true;
            }
            if(target%400==0){
                return true;
            }
            if(target%100==0){
                return false;
            }
        }
        return false;
    }
}
