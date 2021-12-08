import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @Author Gallon
 * @ClassName Exe9_1
 * @Package
 * @Description 创建注册界面，需要检验输入内容是否符合要求（该要求使用正则表达式实现）。
 * @Time 2021-12-08,周三 07:32
 */

public class Exe9_1 extends JFrame implements ActionListener {
    JLabel[] labels=new JLabel[6];
    JTextField[] fields=new JTextField[6];
    JCheckBox checkBox;
    JComboBox<String> comboBox;
    ButtonGroup buttonGroup;
    JButton register;
    JRadioButton radio1;
    JRadioButton radio2;
    JRadioButton radio3;
    JRadioButton radio4;
    public Exe9_1(){
        super("学生注册");


        labels[0]=new JLabel("学号");
        labels[1]=new JLabel("姓名");
        labels[2]=new JLabel("密码");
        labels[3]=new JLabel("再输入一次密码");
        labels[4]=new JLabel("专业");
        labels[5]=new JLabel("年级");
        fields[0]=new JTextField(6);
        fields[1]=new JTextField(6);
        fields[2]=new JTextField(8);
        fields[3]=new JTextField(20);
        buttonGroup=new ButtonGroup();
        radio1=new JRadioButton("一年级");
        radio2=new JRadioButton("二年级");
        radio3=new JRadioButton("三年级");
        radio4=new JRadioButton("四年级");
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);
        buttonGroup.add(radio4);
        comboBox=new JComboBox<String>();
        comboBox.addItem("数学");
        comboBox.addItem("计算机");
        comboBox.addItem("英语");
        JPanel p1=new JPanel(new GridLayout(6,2));
        p1.add(labels[0]);
        p1.add(fields[0]);
        p1.add(labels[1]);
        p1.add(fields[1]);
        p1.add(labels[2]);
        p1.add(fields[2]);
        p1.add(labels[3]);
        p1.add(fields[3]);
        p1.add(labels[4]);
        p1.add(comboBox);
        p1.add(labels[5]);

        JPanel p3=new JPanel(new GridLayout());
        p3.add(radio1);
        p3.add(radio2);
        p3.add(radio3);
        p3.add(radio4);
        p1.add(p3,BorderLayout.CENTER);

        register=new JButton("注册");
        register.addActionListener(this);

        JPanel p0=new JPanel(new BorderLayout());

        p0.add(p1);
        p0.add(register,BorderLayout.SOUTH);
        this.add(p0);
        setSize(400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==register){
            String id=fields[0].getText();
            String name=fields[1].getText();
            String psd1=fields[2].getText();
            String psd2=fields[3].getText();
            boolean id_judge=id.matches("^[0-9]{6}$");
            boolean name_judge=name.matches("^[\\u4e00-\\u9fa5]{0,5}$");
            boolean psd1_judge=psd1.matches("^[0-9a-zA-z_]{5,7}$");
            boolean psd2_judge=psd2.equals(psd1);
            boolean selected=radio1.isSelected()||
                             radio2.isSelected()||
                             radio3.isSelected()||
                             radio4.isSelected();

            if(id_judge&&name_judge&&psd1_judge&&psd2_judge&&selected){

                JOptionPane.showMessageDialog(null,"注册成功！");
            }else{
                JOptionPane.showMessageDialog(null,"注册失败！");
            }






        }
    }


    public static void main(String[] args) {
        Exe9_1 exe9_1=new Exe9_1();
        exe9_1.setVisible(true);
    }

}
