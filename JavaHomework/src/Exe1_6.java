public class Exe1_6 {
    public static void main(String[] args) {
        int count=0;
        boolean[] judge=new boolean[10005];
        for (int i = 2; i*i <=10000; i++) {
            if(judge[i]==false)
            for(int j=i*i;j<=10000;j+=i){
                judge[j]=true;
            }
        }
        for (int i = 2; i < 10000; i++) {

            if(!judge[i]){
                count++;
                System.out.print(i+" ");
            }

        }
        System.out.println("");
        System.out.println(count+"个素数");
    }
}
