import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ShowGraphClass extends JFrame{
	private JPanel back_ground;
	
	ShowGraphClass(){
		/*setVisible(true);
		setSize(700,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(700, 400)); setUndecorated(true);
	    pack();
	    setLayout(null);
	    setVisible(true);
		
		
		createBgPanelMethod();
		drawGraph();
		addExitButton();
	}
	
	private void createBgPanelMethod(){
		PanelClass bg = new PanelClass();
		back_ground = bg.createSimplePanel(0,0,850,650);
		back_ground.setBackground(new Color(1, 1, 1));
		add(back_ground);
	}
	private void drawGraph(){
		ReadWordClass rr = new ReadWordClass();
		String flenm = "C:/Users/ff/Downloads/graph.txt";
		StringArrayToNumberArrayClass cc = new StringArrayToNumberArrayClass();
		int []arr = cc.convetIntoInt(rr.read(1, flenm));
		
		int day=1,wordnum=20;
		for(int i=0;i<arr.length;i++){
			day=i+1;wordnum=arr[i];
			drawline(day*5,400-wordnum*3,back_ground);
		}
		validate();
	}
	
	private void drawline(int x,int y,JPanel panel){
		for(int i=380;i+20>=y;i-=2){
			points(x,i,panel);
		}
	}
	private JLabel points(int x,int y,JPanel panel){
		JLabel label = new JLabel();
		label.setText("|");
		label.setBounds(x,y,10,10);
		//label.setFont(font);
		label.setForeground(Color.green);
		back_ground.add(label);
		return label;
	}
	
	private void addExitButton(){
		Font font = new Font("Serif", Font.BOLD, 10);
		JButton button= new JButton(new AbstractAction("CLOSE") {
	         public void actionPerformed(ActionEvent e) {
	        	 dispose();
	         }
	      });
		button.setBounds(620,0,80,25);
		button.setBackground(Color.red);
		button.setFont(font);
		button.setForeground(Color.white);
		back_ground.add(button);
	}
}
