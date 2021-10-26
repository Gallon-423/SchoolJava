import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Exe5_3 {
    public static void main(String[] args) {
        List<Double> scores=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        for (int i = 0; i < num; i++) {
            double temp=scanner.nextDouble();
            scores.add(temp);
        }
        Cmp cmp=new Cmp();
        scores.sort(cmp);
        scores.forEach(o->{
            System.out.println( o+" "+(scores.indexOf(o)+1));});
    }
    static class Cmp implements Comparator<Double>{

        @Override
        public int compare(Double o1, Double o2) {
            return (o1-o2<=0)?1:-1;
        }
    }

}

