import java.util.Scanner;

public class Exe3_1 {
    public static void main(String[] args) throws Exception {
        DateTime dt=new DateTime(2021,9,28,8,0,0);

        dt.showDate();
        dt.showTime();
        System.out.println(dt);
        dt.modifyDate();

        //输入表示日期的年月日三个数，以空格间隔
        dt.showDate();

        dt.modifyTime();
        //输入表示时刻的时分秒三个数，以空格间隔
        dt.showTime();
    }
    public static class DateTime{
        int year;
        int month;
        int day;
        int hour;
        int min;
        int sec;
        public DateTime() {
        }

        public DateTime(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public DateTime(int year, int month, int day, int hour, int min, int sec) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.min = min;
            this.sec = sec;
        }
        public boolean modifyDate() throws Exception {
            System.out.println("请按年月日的顺序输入：");
            Scanner sc=new Scanner(System.in);
            this.year= sc.nextInt();
            this.month=sc.nextInt();
            this.day=sc.nextInt();
            if(year<=0 || year>12 || month <=0 ||month>12||day<=0||day>31) {
                //不想判断闰年
                System.out.println("输入数据非法");
                throw new Exception("输入数据非法");
            }
            return true;
        }
        public  boolean modifyTime(){
            System.out.println("请按时分秒的顺序输入：");
            Scanner sc=new Scanner(System.in);
            this.hour= sc.nextInt();
            this.min=sc.nextInt();
            this.sec=sc.nextInt();
            if(hour<0 ||hour>=60 || min <=0 ||min>=60||sec<0||sec>=60) {

                System.out.println("输入数据非法");
                return false;
            }
            return true;
        }
        public void showTime(){
            String s;
            s=(hour<10?"0":"")+hour+":"+(min<10?"0":"")+min+":"+(sec<10?"0":"")+sec;
            System.out.println(s);
            //System.out.printf("%d2",hour);
        }
        public void showDate(){
            String s;
            s=year+"-"+month+"-"+day;
            System.out.println(s);

        }

        @Override
        public String toString() {
            return "DateTime{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    ", hour=" + hour +
                    ", min=" + min +
                    ", sec=" + sec +
                    '}';
        }
    }
}
