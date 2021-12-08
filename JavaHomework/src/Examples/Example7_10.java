package Examples;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Example7_10 extends JFrame{
	private JLabel label1;
	
	public Example7_10(){
		super("赢麻了");
		
		label1 = new JLabel();
		label1.setPreferredSize(new Dimension(100, 15));
		label1.setBackground(Color.BLUE);
		label1.setForeground(Color.WHITE);
		label1.setOpaque(true);
		
		setLayout(new FlowLayout());
		getContentPane().add(label1);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		
		addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e){
				System.out.println("��������");
			}
			public void mouseReleased(MouseEvent e){
				System.out.println("�����ͷ�");
			}
			public void mouseEntered(MouseEvent e){
				System.out.println("�����������");
			}
			public void mouseExited(MouseEvent e){
				System.out.println("�����뿪���");
			}
			public void mouseClicked(MouseEvent e){
				System.out.println("���µİ�����" + e.getButton()
					+ "����������" + e.getClickCount());
			}
		});
		
		addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e){
				label1.setText("(x,y) = (" + e.getX() + "," + e.getY() + ")");
			}
			public void mouseMoved(MouseEvent e){
				label1.setText("(x,y) = (" + e.getX() + "," + e.getY() + ")");
			}
		});
	}
	
	public static void main(String[] args){
		Example7_10 e = new Example7_10();
		e.setVisible(true);
	}
};