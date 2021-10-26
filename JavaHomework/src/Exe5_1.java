import java.util.Arrays;

public class Exe5_1 {
    public static void main(String[] args) {
        showMatrix(5);
    }

    static void showMatrix(int num){
        int[][] matrix=new int[num+1][num+1];
        int circleNum=1;
        int i=1; //表示行数
        int j=1; //表示列数
        int count=1;
        int direct=1;//1 往上 2往下 3往左 4往右

        do {
            matrix[i][j] = count++;
            if (i == j && i == circleNum) {
                if (circleNum % 2 == 1) {
                    direct = 1;
                }
                if (circleNum % 2 == 0) {
                    direct = 3;
                }
                circleNum++;
            }
            if (i == 1) {
                if (j % 2 == 1) {
                    direct = 4;
                }
                if (j % 2 == 0) {
                    direct = 2;
                }
            }
            if (j == 1) {
                if (i % 2 == 1) {
                    direct = 4;
                }
                if (i % 2 == 0) {
                    direct = 2;
                }
            }
            if(direct==1){
                i--;
            }
            if (direct == 2) {
                i++;
            }
            if (direct == 3) {
                j--;
            }
            if (direct == 4) {
                j++;
            }
        } while (count != 26);
        for (int k = 1; k <= num ; k++) {
            for (int l = 1; l <= num ; l++) {
                System.out.printf("%5d",matrix[k][l]);
            }
            System.out.println();
        }
    }
}
