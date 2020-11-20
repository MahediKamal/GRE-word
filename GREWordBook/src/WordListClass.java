import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class WordListClass extends JFrame{
	private JPanel back_ground;
	WordListClass(){
//		setVisible(true);
//		setSize(850,650);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(850, 650)); setUndecorated(true);
	    pack();
	    setLayout(null);
	    setVisible(true);
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		createBgPanelMethod();
		createWordGroupTitle(0,"Common");
		createWordGroupTitle(200,"Basic");
		createWordGroupTitle(400,"Advance");
		createCommonWordGroupButton();
		addExitButtonOnMenuPanelMethod();
		addPrevButtonOnBGMethod();
	}
	
	private void createBgPanelMethod(){
		PanelClass bg = new PanelClass();
		back_ground = bg.createImagePanelMethod(0,0,850,650);
		add(back_ground);
	}
	
	private void createWordGroupTitle(int y,String text){
		Font font = new Font("Serif", Font.ITALIC, 24);
		JLabel common = new JLabel("",SwingConstants.CENTER);
		common.setBounds(0, y, 850,30);
		common.setOpaque(true);
		common.setBackground(Color.CYAN);
		common.setText(text);
		common.setFont(font);
		back_ground.add(common);
	}
	private void createCommonWordGroupButton(){
		ButtonClass bg = new ButtonClass();
		JButton btnc1 = bg.createTextButtonOnPanel(60, 60, 110, 110, "20 words",back_ground);
		btnc1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ShowWordClass frame3 = new ShowWordClass(20,1);
				//setVisible(false);
				dispose();
			}
		});
		JButton btnc2 = bg.createTextButtonOnPanel(210, 60, 110, 110, "30 words",back_ground);
		JButton btnc3 = bg.createTextButtonOnPanel(360, 60, 110, 110, "40 words",back_ground);
		JButton btnc4 = bg.createTextButtonOnPanel(510, 60, 110, 110, "50 words",back_ground);
		JButton btnc5 = bg.createTextButtonOnPanel(660, 60, 110, 110, "60 words",back_ground);
		
		
		JButton btnb1 = bg.createTextButtonOnPanel(60, 260, 110, 110, "40 words",back_ground);
		JButton btnb2 = bg.createTextButtonOnPanel(210, 260, 110, 110, "50 words",back_ground);
		JButton btnb3 = bg.createTextButtonOnPanel(360, 260, 110, 110, "60 words",back_ground);
		JButton btnb4 = bg.createTextButtonOnPanel(510, 260, 110, 110, "70 words",back_ground);
		JButton btnb5 = bg.createTextButtonOnPanel(660, 260, 110, 110, "80 words",back_ground);
		
		
		JButton btna1 = bg.createTextButtonOnPanel(60, 460, 110, 110, "60 words",back_ground);
		JButton btna2 = bg.createTextButtonOnPanel(210, 460, 110, 110, "70 words",back_ground);
		JButton btna3 = bg.createTextButtonOnPanel(360, 460, 110, 110, "80 words",back_ground);
		JButton btna4 = bg.createTextButtonOnPanel(510, 460, 110, 110, "90 words",back_ground);
		JButton btna5 = bg.createTextButtonOnPanel(660, 460, 110, 110, "100 words",back_ground);
	}
	
	private void addExitButtonOnMenuPanelMethod(){
		Font font = new Font("Serif", Font.ITALIC, 20);
		JButton button= new JButton(new AbstractAction("Close") {
	         public void actionPerformed(ActionEvent e) {
	            System.exit(0);
	         }
	      });
		button.setBounds(363,590,100,50);
		button.setBackground(Color.red);
		button.setFont(font);
		button.setForeground(Color.white);
		back_ground.add(button);
	}
	private void addPrevButtonOnBGMethod(){
		ImageIcon img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\back.PNG");
		ButtonClass bt = new ButtonClass();
		JButton prev_btn = bt.createimageButtonInPanel(10, 590, 70, 50, img, back_ground);
		prev_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MenuFrameClass frame1=new MenuFrameClass("disable","enable");
				//setVisible(false);
				dispose();
			}
		});
	}
}
