package Examples;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class Example7_12_Panel extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		

		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(4));
		g.setColor(Color.ORANGE);
		g.drawLine(25, 25, width - 25, 25);
		g.drawLine(width - 25, 25, width - 25, height - 25);
		g.drawLine(width - 25, height - 25, 25, height - 25);
		g.drawLine(25, height - 25, 25, 25);
		

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 50, 50);
		g.fillRect(width - 50, 0, 50, 50);
		g.fillRect(width - 50, height - 50, 50, 50);
		g.fillRect(0, height - 50, 50, 50);
		

		g.setColor(Color.RED);
		g.fillOval(width / 2 - 50, height / 2 - 25, 100, 50);
	}
}
public class Example7_12 extends JFrame{
	public Example7_12(){
		super("");
		
		getContentPane().add(new Example7_12_Panel());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);		
	}
	
	
	public static void main(String[] args){
		Example7_12 e = new Example7_12();
		e.setVisible(true);
	}
};