public class Exe3_2 {
    public static void main(String[] args) {

        Complex c1=new Complex(8,2);
        Complex c2=new Complex(-4,-1);
        System.out.println("第一个数为 "+c1);
        System.out.println("第二个数为 "+c2);

        System.out.println("相加操作的结果：");
        Complex plusAns=Complex.plus(c1,c2);
        System.out.println(plusAns);
        //相加操作

        System.out.println("减法操作的结果：");
        Complex subAns=Complex.sub(c1,c2);
        System.out.println(subAns);
        //减法操作

        System.out.println("相乘操作的结果：");
        Complex mulAns=Complex.mul(c1,c2);
        System.out.println(mulAns);
        //相乘操作

        System.out.println("除法操作的结果：");
        Complex didAns=Complex.did(c1,c2);
        System.out.println(didAns);
        //除法操作


    }

    public static class Complex{
        double a;//表示实部

        double b;//表示虚部

        public Complex(){}

        public Complex(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public double getA() {
            return a;
        }

        public void setA(double a) {
            this.a = a;
        }

        public double getB() {
            return b;
        }

        public void setB(double b) {
            this.b = b;
        }

        static public Complex plus(Complex c1, Complex c2){
            Complex c=new Complex(c1.a+c2.a,c1.b+c2.b);
            return c;
        }
        static public Complex sub(Complex c1, Complex c2){
            Complex c=new Complex(c1.a-c2.a,c1.b-c2.b);
            return c;
        }
        static public Complex mul(Complex c1, Complex c2){
            double b1=c1.b;
            double b2=c2.b;
            double a1=c1.a;
            double a2=c2.a;
            double temp1=a1*a2;//之后的整数
            double temp2=b1*b2*(-1);//之后的整数
            double temp3=a1*b2;
            double temp4=a2*b1;
            Complex c=new Complex(temp1+temp2,temp3+temp4);
            return c;
        }
        public static Complex each(Complex Ori){
            //取补
            double a=Ori.a;
            double b=Ori.b;
            double temp=a*a+b*b;
            return new Complex(a/temp,(-1)*b/temp);
        }
        public static Complex did(Complex c1, Complex c2){
            Complex cEach=each(c2);
            Complex ans=mul(c1,cEach);
            return ans;
        }

        @Override
        public String toString() {
            String s;
            if(b==0){
                s= "值为"+" "+ a+" ";
            }else{
                if(b>0){
                    s="值为"+" "+ a+"+"+b+" i";
                }else{
                    s="值为"+" "+ a+b+" i";
                }
            }
            return s;

        }
    }
}
