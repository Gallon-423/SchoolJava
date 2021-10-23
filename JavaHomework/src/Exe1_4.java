public class Exe1_4 {
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            int height = Math.abs(5-i-1);
            int spaceNum=height;
            int charNum=9-2*height;
            for (int j = 0; j < spaceNum; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < charNum; k++) {
                System.out.print("A");
            }
            for (int j = 0; j < spaceNum; j++) {
                System.out.print(" ");
            }
            System.out.println("");
        }

    }
}
