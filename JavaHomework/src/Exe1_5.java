import java.util.Arrays;

public class Exe1_5 {


    public static void main(String[] args) {

        int[] array=new int[9];
        array[0]=1;
        System.out.println(array[0]);
        for (int i = 1; i < 9; i++) {
            int[] temp= Arrays.copyOf(array,9);
            array[0]=1;
            array[i]=1;
            for (int j = 1; j < i; j++) {
                array[j]=temp[j]+temp[j-1];
            }
            for (int num:array
                 ) {
                if(num==0){
                break;
                }
                System.out.print(num+" ");
            }
            System.out.println("");
        }
    }
}
