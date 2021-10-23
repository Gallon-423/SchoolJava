public class Exe1_3 {
    public static void main(String[] args) {
        String origin="Java";
        //原始字符串；
        char[] a=origin.toCharArray();
        //将字符串转换为char数组。
        for (char element:a
             ) {
            int data1=Integer.valueOf(element);
            int data2=data1+2;
            int data=data1^data2;
            System.out.print((char) data);
        }
    }
}
