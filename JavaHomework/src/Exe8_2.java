import javax.swing.*;
import java.awt.*;

public class Exe8_2 {
    public static void createGUI(){
        JFrame jFrame = new JFrame("棋盘");
        jFrame.setSize(600, 600);
        jFrame.setResizable(false);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(9, 9, 0, 0));
        for (int i = 0; i < 81; i++)
        {
            if (i % 2 == 0) {
                JButton jButton = new JButton();
                jButton.setBackground(Color.black);
                jPanel.add(jButton);
            } else if (i % 2 == 1) {
                JButton jButton = new JButton();
                jButton.setBackground(Color.white);
                jPanel.add(jButton);
            }

        }
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
