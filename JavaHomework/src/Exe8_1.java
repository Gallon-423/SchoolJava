import javax.swing.*;
import java.awt.*;
/**
 * @Author Gallon
 * @ClassName Exe8_1
 * @Description  窗口标题设置
 * @Time 2021-11-23,周二 16:27
 */

public class Exe8_1 {
    private static void createGUI()
    {
        JFrame frame = new JFrame("欢迎来到Java GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        frame.setSize(600, 600);
        frame.setResizable(false);
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
