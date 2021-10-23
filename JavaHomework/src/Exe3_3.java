public class Exe3_3 {
    public static void main(String[] args) {
        Dot d=new Dot();
        System.out.println("面积为 "+d.area()+"周长为 "+d.lenSum());
        Line line =new Line(5);
        System.out.println("面积为 "+line.area()+"周长为 "+line.lenSum());
        Rec r=new Rec(4,6);
        System.out.println("面积为 "+r.area()+"周长为 "+r.lenSum());
        Circle c=new Circle(4);
        System.out.println("面积为 "+c.area()+"周长为 "+c.lenSum());
        Tri t=new Tri(3,4,6);
        System.out.println("面积为 "+t.area()+"周长为 "+t.lenSum());


    }

    static public abstract class Shape{

        abstract double area();
        //求面积
        abstract double lenSum();
        //求周长
    }
    static public class Dot extends Line{

        
        public Dot() {
            len=0;
        }

        @Override
        double area() {
            return 0;
        }

        @Override
        double lenSum() {
            return len;
        }
    }

    public static class Line extends Rec{
        static double len;

        public Line(int len) {
            super(len,0);
            this.len = len;
            wid=0;
        }

        public Line() {
            super(0,0);
            wid=0;
        }

        @Override
        double area() {
            return 0;
        }

        @Override
        double lenSum() {
            return len;
        }
    }
    
    
    public static class Rec extends Shape{
        
        double len;
        double wid;

        public Rec(double len,double wid) {
            this.len=len;
            this.wid=wid;
        }


        @Override
        double area() {
            return len*wid;
        }

        @Override
        double lenSum() {
            return len*2+wid*2;
        }
    }

    public static class Tri extends Shape{

        double a;
        double b;
        double c;

        public Tri(double a, double b, double c) {
            this.a=a;
            this.b=b;
            this.c=c;
        }

        @Override
        double area() {
            double len=(a+b+c)/2;
            return Math.sqrt(len*(len-a)*(len-b)*(len-c));
        }

        @Override
        double lenSum() {
            return a+b+c;
        }
    }
    public static class Circle extends Shape{
        double r;

        public Circle(double r) {
            this.r = r;
        }

        public Circle() {
        }

        @Override
        double area() {
            return Math.PI*r*r;
        }

        @Override
        double lenSum() {
            return 2*Math.PI*r;
        }
    }
}
