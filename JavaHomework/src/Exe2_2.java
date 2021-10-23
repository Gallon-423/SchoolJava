public class Exe2_2 {
    public static void main(String[] args) {
    double pi=4.0;
    double a;
    double mother=3.0;
    double sign=-1.0;
    double temp=0;
    while(Math.abs(pi-temp)>0.0000001){
        temp=pi;
        pi+=(sign*4.0/mother);
        mother+=2.0;
        sign*=(-1.0);


    }
        System.out.printf("%.7f",pi);



    }
}
