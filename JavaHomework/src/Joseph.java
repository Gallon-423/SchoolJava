public class Joseph {
    public static void main(String[] args) {
        int fielter=3;
        int num=100;
        int outCount=0;
        int triCount=0;
        int ary[]=new int[100];
        int temp = 0;
        for (int i = 0; i < 100 ; i++) {
            ary[i]=1;
        }
        for(int i=0;outCount<99;i=(i+1)%100){
            if(ary[i]==0) continue;

            if(triCount!=2){
                triCount++;
                temp=i;
            }
            else if(triCount==2){
                ary[i]=0;
                triCount=0;
                outCount++;
            }
        }
        System.out.println(temp+1);


    }
}
