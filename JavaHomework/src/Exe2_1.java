public class Exe2_1 {


    public static void main(String[] args) {
        int count=0;
        for (int i = 1; i*3 < 100; i++) {
            //母鸡
            for (int j = 0; j < 300; j+=3) {
                //小鸡
                for (int k = 0; k <=100; k++) {
                    //公鸡
                        if(i*3+j/3+k==100&&i+j+k==100){
                            count++;
                            System.out.println("第"+count+"种可能：");
                            System.out.println("母鸡有"+i+"只");
                            System.out.println("小鸡有"+j+"只");
                            System.out.println("公鸡有"+k+"只");
                        }

                }
            }
        }
    }
}
