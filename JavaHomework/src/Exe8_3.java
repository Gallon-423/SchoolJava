import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exe8_3 {
    private static void createGUI()
    {
        final int[] i = {0};
        JFrame frame = new JFrame("Exe8_3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.red);
        frame.setLayout(new GridLayout());
        jPanel.addMouseListener( new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(e.getButton() == MouseEvent.BUTTON1){
                    i[0]++;
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
