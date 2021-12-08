import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @Author Gallon
 * @ClassName Exe8_3
 * @Description  鼠标事件点击（点击左键右键均可）切换幻灯片，红绿蓝播放
 * 左键点击切换顺序为：红绿蓝（正序）， 右键点击切换顺序为：蓝绿红（逆序）。
 * @Time 2021-11-23,周二 16:28
 */

public class Exe8_3 {
    private static void createGUI()
    {
        final int[] i = new int[]{0};
        JFrame frame = new JFrame("Exe8_3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.red);
        frame.setLayout(new GridLayout());
        jPanel.addMouseListener( new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(e.getButton() == MouseEvent.BUTTON1 ){
                    i[0]++;
                    if ((i[0] % 3) == 0) jPanel.setBackground(Color.red);
                    else if ((i[0] % 3) == 1) jPanel.setBackground(Color.green);
                    else if ((i[0] % 3) == 2) jPanel.setBackground(Color.blue);
                }else if(e.getButton() == MouseEvent.BUTTON3){
                    i[0]--;
                    if (i[0]<0) i[0]=i[0]+3;
                    if ((i[0] % 3) == 0) jPanel.setBackground(Color.red);
                    else if ((i[0] % 3) == 1) jPanel.setBackground(Color.green);
                    else if ((i[0] % 3) == 2) jPanel.setBackground(Color.blue);
                }
            }

        });

        frame.add(jPanel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }

}
