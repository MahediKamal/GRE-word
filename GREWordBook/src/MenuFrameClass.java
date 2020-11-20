import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class MenuFrameClass extends JFrame{

	private JPanel back_ground;
	private JPanel option_panel;
	//private int ban,eng;
	private JLabel ban_label,eng_label,reset;
	private JButton btnban,btneng,btnreset,btngraph;
	private int []ban_eng;
	private int []master_word_identity;
	private int []array;
	private int section;
	
	public MenuFrameClass(String bangla,String hindi){
		///setting Jframe
		/*setVisible(true);
		setSize(850,650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(850, 650)); setUndecorated(true);
	    pack();
	    setLayout(null);
	    setVisible(true);
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		section=1;
		
		ReadWordClass rdd = new ReadWordClass();
		String flenm= "C:/Users/ff/Downloads/sec1.txt";
		String []master_w = rdd.read(1, flenm);
		StringArrayToNumberArrayClass nmm = new StringArrayToNumberArrayClass();
		master_word_identity = nmm.convetIntoInt(master_w);
		
		String filename = "C:/Users/ff/Downloads/mastered.txt";
		rdd = new ReadWordClass();
		String []arr1 = rdd.read(1, filename);
		//int[] array = Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
		StringArrayToNumberArrayClass nm = new StringArrayToNumberArrayClass();
		array = nm.convetIntoInt(arr1);
		
		
		createBgPanelMethod();
		createMenuPanelMethod();
		addStartbuttonOnBGPanel();
		fillupMenuPanelMethod(bangla,hindi);
		addExitButtonOnMenuPanelMethod();
		addImportantWordAndQuickTestButtonOnBGPanel();
		//validate();
	}
	
	
	private void createBgPanelMethod(){
		PanelClass bg = new PanelClass();
		back_ground = bg.createImagePanelMethod(0,0,850,650);
		add(back_ground);
	}
	
	
	private void createMenuPanelMethod(){
		PanelClass bg = new PanelClass();
		option_panel= bg.createSimplePanel(630,0,220,650);
		back_ground.add(option_panel);
	}
	
	private void addImportantWordAndQuickTestButtonOnBGPanel(){
		Font font = new Font("Serif", Font.ITALIC, 23);
		ButtonClass bb = new ButtonClass();
		
		JButton btnImportant = bb.createTextButtonOnPanel(100, 10, 200, 60, "Important Words", back_ground);
		btnImportant.setFont(font);
		btnImportant.setForeground(Color.green);
		btnImportant.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ShowImportantWordClass f2 = new ShowImportantWordClass();
			}
		});
		
		JButton btnTest = bb.createTextButtonOnPanel(310, 10, 200, 60, "Quick Test", back_ground);
		btnTest.setFont(font);
		btnTest.setForeground(Color.green);
		btnTest.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ShowQuickTestClass ff = new ShowQuickTestClass();
			}
		});
		//btnTest.setBackground(Color.green);
	
	}
	
	private void addStartbuttonOnBGPanel(){
		int b_x=245,l_y=330,b_width=92,b_height=92;
		ImageIcon img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\start.PNG");
		JButton button = new JButton(img);
		button.setBounds(b_x,l_y,b_width,b_height);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				WordListClass frame4 = new WordListClass();
				//setVisible(false);
				dispose();
			}
		});
		back_ground.add(button);
	}
	
	
	private void fillupMenuPanelMethod(String status_bangla,String status_hindi){
		ban_label = new JLabel();eng_label = new JLabel();reset = new JLabel();
		
		ReadWordClass rd = new ReadWordClass();
		String flenm= "C:/Users/ff/Downloads/state.txt";
		String []arr = rd.read(1, flenm);
		//ban=Integer.parseInt(arr[0]);eng=Integer.parseInt(arr[1]);
		StringArrayToNumberArrayClass cnn = new StringArrayToNumberArrayClass();
		ban_eng = cnn.convetIntoInt(arr);
		
		ImageIcon img;
		String label_text;
		ButtonClass btn = new ButtonClass();
		if(ban_eng[0]==1){
			img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\disable.PNG");
			label_text="Bangla Disabled";
		}else{
			img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\enable.PNG");
			label_text="Bangla Enabled";
		}
		btnban = btn.createImageButtonAndLabelOnPanel(140, 10, 50, 50, img, 5, 5, 150, 50, label_text, option_panel,ban_label);
		btnban.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ban_eng[0]==1) ban_eng[0]=0;
				else ban_eng[0]=1;
				setBanglaEnglishButton();
			}
		});
		
		
		if(ban_eng[1]==1){
			img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\disable.PNG");
			label_text="Hindi Disabled";

		}else{
			img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\enable.PNG");
			label_text="Hindi Enabled";
		}
		btneng = btn.createImageButtonAndLabelOnPanel(140, 70, 50, 50, img, 5, 65, 150, 50, label_text, option_panel,eng_label);
		btneng.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ban_eng[1]==1) ban_eng[1]=0;
				else ban_eng[1]=1;
				setBanglaEnglishButton();
			}
		});
		
		//----------------------------------------reset button -----------------------------
		img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\reset.PNG");
		label_text="Reset All";
		btnreset = btn.createImageButtonAndLabelOnPanel(140, 130, 50, 50, img, 5, 125, 150, 50, label_text, option_panel,reset);
		btnreset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, " reset done !!");
				reset();
			}
		});
		//------------------------------progress graph button----------------------
		Font font = new Font("Serif", Font.ITALIC, 18);
		btngraph = btn.createTextButtonOnPanel(30, 200, 150, 50, "Pogress Graph", option_panel);
		btngraph.setForeground(Color.green);
		btngraph.setFont(font);
		btngraph.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ShowGraphClass ff = new ShowGraphClass();
			}
		});
	}
	
	private void reset(){
		for(int i=0;i<master_word_identity.length;i++){
			master_word_identity[i]=0;
		}
		array[section]=0;
		
		ReadWordClass rd = new ReadWordClass();
		String flenm= "C:/Users/ff/Downloads/important.txt";
		String []arr = new String[1];arr[0]="DUMYword";
		rd.writestr(flenm,arr);
		save();
	}
	
	private void setBanglaEnglishButton(){
		ImageIcon img;
		String label_text;
		if(ban_eng[0]==1){
			img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\disable.PNG");
			label_text="Bangla Disabled";
		}else{
			img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\enable.PNG");
			label_text="Bangla Enabled";
		}
		ban_label.setText(label_text);
		btnban.setIcon(img);
		
		if(ban_eng[1]==1){
			img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\disable.PNG");
			label_text="Hindi Disabled";

		}else{
			img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\enable.PNG");
			label_text="Hindi Enabled";
		}
		eng_label.setText(label_text);
		btneng.setIcon(img);
		
		save();
	}
	private void save(){
		ReadWordClass rr = new ReadWordClass();
		String flenm= "C:/Users/ff/Downloads/sec1.txt";
		rr.write(flenm, master_word_identity);
		flenm= "C:/Users/ff/Downloads/mastered.txt";
		rr.write(flenm, array);
		flenm= "C:/Users/ff/Downloads/state.txt";
		rr.write(flenm, ban_eng);
		flenm= "C:/Users/ff/Downloads/graph.txt";
		int []a = new int[1];a[0]=-3;
		rr.write(flenm, a);
	}
	
	private void addExitButtonOnMenuPanelMethod(){
		Font font = new Font("Serif", Font.ITALIC, 20);
		JButton button= new JButton(new AbstractAction("Close") {
	         public void actionPerformed(ActionEvent e) {
	            System.exit(0);
	         }
	      });
		button.setBounds(60,590,100,50);
		button.setBackground(Color.red);
		button.setFont(font);
		button.setForeground(Color.white);
		option_panel.add(button);
	}
}
