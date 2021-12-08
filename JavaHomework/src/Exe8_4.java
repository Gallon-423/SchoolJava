import javafx.scene.control.PasswordField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * @Author Gallon
 * @ClassName Exe8_4
 * @Description  创建用户登录界面
 * @Time 2021-11-23,周二 16:29
 */

public class Exe8_4 {
    private static void createGUI(){
        MyFrame myFrame=new MyFrame();
        myFrame.setVisible(true);
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

class MyFrame extends JFrame implements ActionListener{

    JPanel panel;
    JLabel label,label2;
    JButton MyFrameButton;
    JTextField jTextField1;
    JTextField jTextField2;
    JPasswordField passwordField;
    public MyFrame() {
        this.setTitle("用户登录界面");
        this.setSize(220,220);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        panel.setSize(200,200);
        label = new JLabel("用户名");
        label2 = new JLabel("密 码");
        MyFrameButton = new JButton("登录");
        MyFrameButton.addActionListener(this);
        jTextField1 = new JTextField(12);
        jTextField2 = new JTextField(12);
        panel.add(label);
        panel.add(jTextField1);
        panel.add(label2);
        panel.add(jTextField2);
        panel.add(MyFrameButton);
        this.add(panel);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==MyFrameButton) {
            if (jTextField1.getText().equals("JavaUser") && jTextField2.getText().equals("Java1234")) {
                JOptionPane.showMessageDialog(null,"登录成功！");
            }else {
                JOptionPane.showMessageDialog(null,"登录失败！");
            }

        }
    }
}