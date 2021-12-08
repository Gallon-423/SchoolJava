import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Exe9_2 extends JFrame {
    JLabel label;
    JButton button;
    JPanel panel1;
    JPanel panel2;
    public Exe9_2() {
        super("获取坐标");
        this.setSize(400,400);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label=new JLabel();
        label.setVisible(true);
        label.setPreferredSize(new Dimension(200, 100));
        label.setBackground(Color.blue);
        label.setForeground(Color.white);
        label.setOpaque(true);
        setLayout(new FlowLayout());
        getContentPane().add(label);
        MouseAdapter result1=new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);

                String x=Integer.toString(e.getXOnScreen());
                String y=Integer.toString(e.getYOnScreen());
                label.setText('('+x+","+y+')');

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                String x=Integer.toString(e.getXOnScreen());
                String y=Integer.toString(e.getYOnScreen());
                label.setText('('+x+","+y+')');
            }
        };

        addMouseMotionListener(result1);
        JButton button=new JButton();
        button.addMouseListener(new MouseAdapter() {
            int mark=0;
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(mark==0){
                    mark=1;
                    label.setForeground(Color.blue);
                }else{
                    mark=0;
                    label.setForeground(Color.white);
                }

            }
        });
        button.setPreferredSize(new Dimension(100,50));
        panel1=new JPanel(new BorderLayout());
        panel1.add(button,BorderLayout.CENTER);
        panel2=new JPanel(new BorderLayout());
        panel2.add(label,BorderLayout.CENTER);
        JPanel panel=new JPanel(new BorderLayout());
        panel.add(panel2,BorderLayout.NORTH);
        panel.add(panel1,BorderLayout.SOUTH);

        this.add(panel);

    }

    public static void main(String[] args) {
        Exe9_2 exe9_2=new Exe9_2();
        exe9_2.setVisible(true);
    }
}
