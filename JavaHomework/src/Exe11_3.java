import java.util.*;

/**
 * @Author Gallon
 * @ClassName Exe11_3
 * @Description  买票问题（看起来是一个多线程问题）
 * @Time 2021-12-21,周二 19:49
 */

public class Exe11_3 {
    public static void main(String[] args) throws InterruptedException {
        //用随机数生成 100 个持有不同金额纸币的购票者数组
        int[] customers=new int[100];
        Random random=new Random();
        int[] moneyTypes=new int[]{10,10,10,10,10,10,10,10,10,50,100,100,100,100,100,100,100,100,100,100};//该随机概率能比较好地广泛覆盖多种情况
        int num=1;
        for (int j= 0; j < 100; j++) {
            customers[j]=moneyTypes[random.nextInt(20)];
        }
        int i;
        int changeNum=0;
        for(i=0;i<100;i++){
            Thread.sleep(5);
            //模拟过程
            //当零钱充足的情况下时优先为等待时间长的顾客服务
            if(customers[i]==10){
                changeNum++;
                System.out.println("第 "+i+" 位顾客花 "+customers[i]+
                        " 元买到了票，现在售票员有 "+changeNum*10+" 元零钱");
                customers[i]=0;
                i=0;
            }else if (customers[i]==50){
                if(changeNum<4) continue;
                changeNum-=4;
                System.out.println("第 "+i+" 位顾客花 "+customers[i]+
                        " 元买到了票，现在售票员有 "+changeNum*10+" 元零钱");
                customers[i]=0;
            }else if (customers[i]==100){
                if(changeNum<9) continue;
                changeNum-=9;
                System.out.println("第 "+i+" 位顾客花 "+customers[i]+
                        " 元买到了票，现在售票员有 "+changeNum*10+" 元零钱");
                customers[i]=0;
            }

        }
        System.out.println("其余顾客买不了票，别看电影了，回家看电视~");

    }
}
