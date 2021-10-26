import java.util.Scanner;

public class Exe5_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(wordCount(str));
        System.out.println(str);
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
