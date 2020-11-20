import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class TestFrame extends JFrame{
	TestFrame(){
		setVisible(true);
		setSize(850,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		PanelClass bg = new PanelClass();
		
		add(bg.createImagePanelMethod(0,0,850,650));
	}
}
