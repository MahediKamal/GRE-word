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


public class ShowImportantWordClass extends JFrame{
	private JPanel back_ground;
	private JLabel word_label;
	private int word_num;
	ShowImportantWordClass(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(350, 250)); setUndecorated(true);
	    pack();
	    setLayout(null);
	    setVisible(true);
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		word_num=1;
		
		createBgPanelMethod();
		addExitButton();
		addWordLabel();
		addPrevButtonAndNxtButtonOnBGMethod();
		
	}
	
	private void addWordLabel(){
		Font font = new Font("Serif", Font.ITALIC, 20);
		
		word_label = new JLabel();
		word_label.setText("");
		word_label.setFont(font);
		word_label.setBounds(100,60,200,150);
		word_label.setForeground(Color.WHITE);
		back_ground.add(word_label);
	}
	private void addPrevButtonAndNxtButtonOnBGMethod(){
		ImageIcon img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\S-prv.PNG");
		ButtonClass bt = new ButtonClass();
		JButton prev_btn = bt.createimageButtonInPanel(0, 205, 56, 45, img, back_ground);
		
		prev_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(word_num>1){
					word_num--;
					showWrd();
				}
			}
		});
		
		
		
		img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\S-nxt.PNG");
		JButton nxt_btn = bt.createimageButtonInPanel(294, 205, 56, 45, img, back_ground);
		
		nxt_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String filename = "C:/Users/ff/Downloads/important.txt";
				ReadWordClass rr = new ReadWordClass();
				String [] arr= rr.read(1,filename);
				if(word_num<arr.length-1){
					word_num++;
					showWrd();
				}
			}
		});
		
		
		JButton delete_btn = bt.createTextButtonOnPanel(130, 80, 70, 30, "delete", back_ground);
		delete_btn.setBackground(Color.orange);
		delete_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				delete();
			}
		});
		
		showWrd();
		
	}
	private void delete(){
		String filename = "C:/Users/ff/Downloads/important.txt";
		ReadWordClass rr = new ReadWordClass();
		String [] arr= rr.read(1,filename);
		if(arr.length<=1){
			word_label.setText("");
			return;
		}
		String [] cur = new String[arr.length-1];
		for(int i=0;i<word_num;i++){
			cur[i] = arr[i];
		}
		for(int i=word_num+1;i<arr.length;i++){
			if(i>0)
				cur[i-1] = arr[i];
		}
		if(word_num-1>=1) word_num--;
		else word_num++;
		rr.writestr(filename, cur);
		showWrd();
	}
	
	private void showWrd(){
		String filename = "C:/Users/ff/Downloads/important.txt";
		ReadWordClass rr = new ReadWordClass();
		String [] arr= rr.read(1,filename);
		if(arr.length==1) word_label.setText("");
		else word_label.setText(arr[word_num]);
	}
	
	private void createBgPanelMethod(){
		PanelClass bg = new PanelClass();
		back_ground = bg.createSimplePanel(0,0,350,250);
		back_ground.setBackground(Color.BLUE);
		add(back_ground);
	}
	private void addExitButton(){
		Font font = new Font("Serif", Font.BOLD, 10);
		JButton button= new JButton(new AbstractAction("CLOSE") {
	         public void actionPerformed(ActionEvent e) {
	        	 dispose();
	         }
	      });
		button.setBounds(270,0,80,25);
		button.setBackground(Color.red);
		button.setFont(font);
		button.setForeground(Color.white);
		back_ground.add(button);
	}
}
