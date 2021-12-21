import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.geom.Line2D.Double;
import java.math.*;
import java.time.LocalTime;
/**
 * @Author Gallon
 * @ClassName Exe11_2
 * @Description
 * 动态时钟,参考 https://www.cnblogs.com/LeafLove/p/14643075.html
 * 简而言之。懒得写
 * @Time 2021-12-21,周二 19:43
 */

public class Exe11_2 {

    public static void main(String[] args) {

        ActionListener listener = new TimerClock();
        Timer t = new Timer(1000, listener);
        t.start();
        //System.exit(0);
    }

}

class ClockWindow extends JFrame {
    ClockWindow() {
        add(new ClockInfo());
        pack();
    }
}

class ClockInfo extends JComponent {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        this.setPreferredSize(new Dimension(400,400));

        g2.setPaint(Color.red);

        int cx = 200, cy = 200;
        int width=400;
        int height=400;
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



        //绘制指针
        double hour = 6 * Math.PI / 6.0;
        double minute = LocalTime.now().getMinute() * Math.PI / 30.0;
        double second = LocalTime.now().getSecond() * Math.PI / 30.0;
        //时针
        g2.setPaint(Color.black);
        g2.setStroke(new BasicStroke(4.0f));
        g2.draw(new Line2D.Double(cx, cy, cx + 120.0 * Math.sin(hour), cy - 120.0 * Math.cos(hour)));
        //分针
        g2.setPaint(Color.black);
        g2.setStroke(new BasicStroke(2.0f));
        g2.draw(new Line2D.Double(cx, cy, cx + 140.0 * Math.sin(minute), cy - 140.0 * Math.cos(minute)));
        //秒针
        g2.setPaint(Color.black);
        g2.setStroke(new BasicStroke(1.0f));
        g2.draw(new Line2D.Double(cx, cy, cx + 160.0 * Math.sin(second), cy - 160.0 * Math.cos(second)));
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

class TimerClock implements ActionListener {
    ClockWindow frame;

    TimerClock() {
        frame = new ClockWindow();
        frame.setTitle("MyClock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        frame.repaint();
    }

}