import javax.swing.*;
import java.awt.*;
/**
 * @Author Gallon
 * @ClassName Exe9_3_Panel
 * @Package
 * @Description 静态时钟 （这一天，我又想起了被小乌龟支配的恐惧）
 * @Time 2021-12-08,周三 10:04
 */

class Exe9_3_Panel extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();




//        g.setColor(Color.BLUE);
//        g.fillRect(0, 0, 50, 50);
//        g.fillRect(width - 50, 0, 50, 50);
//        g.fillRect(width - 50, height - 50, 50, 50);
//        g.fillRect(0, height - 50, 50, 50);


        g.setColor(Color.BLUE);
        g.fillOval(0, 0, 400, 400);
        g.setColor(Color.WHITE);
        g.fillOval(width/2-15,15,30,30);
        g.fillOval(width/2-15,height-45,30,30);
        g.fillOval(15,height/2-15,30,30);
        g.fillOval(width-45,height/2-15,30,30);

        g.fillOval(width/2+58,45,20,20);
        g.fillOval(width/2-78,45,20,20);
        g.fillOval(width/2+58,height-45,20,20);
        g.fillOval(width/2-78,height-45,20,20);

        g.fillOval(width-80,height/2-90,20,20);
        g.fillOval(60,height/2-90,20,20);
        g.fillOval(width-80,height/2+90,20,20);
        g.fillOval(60,height/2+90,20,20);


        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(8));
        g.setColor(Color.BLACK);
        g.drawLine(width/2,height/2,width/2,height-140);

        g2.setStroke(new BasicStroke(4));
        g.setColor(Color.BLACK);
        g.drawLine(width/2,height/2,width/2,90);

        g2.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        g.drawLine(width/2,height/2,width/2+58,45);


    }
}
/**
 * @Author Gallon
 * @ClassName Exe9_3_Panel
 * @Package
 * @Description 静态时钟（bushi） -> 画画题
 * @Time 2021-12-08,周三 10:05
 */

public class Exe9_3 extends JFrame{
    public Exe9_3(){
        super("");

        getContentPane().add(new Exe9_3_Panel());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(410, 440);
        setResizable(false);
    }


    public static void main(String[] args){
        Exe9_3 e = new Exe9_3();
        e.setVisible(true);
    }
};