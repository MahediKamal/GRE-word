import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanelClass {
	PanelClass(){
		
	}
	public JPanel createImagePanelMethod(int x,int y,int w,int h){
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(MenuFrameClass.class.getResource("/images/bg.PNG"));  
			    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
			}  
		};
		panel.setBounds(x,y,w,h);
		panel.setLayout(null);
		return panel;
	}
	
	public JPanel createSimplePanel(int x,int y,int w,int h){
		JPanel panel = new JPanel();
		panel.setBounds(x,y,w,h);
		panel.setBackground(Color.darkGray);
		panel.setLayout(null);
		return panel;
	}
}
