import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ShowWordClass extends JFrame{
	private JPanel back_ground;
	private JPanel word_panel;
	private JPanel option_panel;
	private int show_word;
	private int gre_word_num;
	//private int ban,eng;
	private JLabel ban_label,eng_label,reset;
	private JButton btnban,btneng,btnreset,btnmaster,btnimportant;
	private int []array;
	private int []master_word_identity;
	private int []ban_eng;
	private int section;
	private JLabel mastered_word_num;
	private int total_word_num=10;
	
	private JLabel word,type,meaning1,meaning2,meaning3,meaning4,meaning5,meaning6,phrase,examples1,examples2,synonymous,antonymous,mnemonics,note1,note2,note3;
	//private JPanel WordMeaningPanel;
	private String gre_word;
	public ShowWordClass(int Word_amount,int section){
		///setting Jframe
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(850, 650)); setUndecorated(true);
	    pack();
	    setLayout(null);
	    setVisible(true);
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		show_word=1;
		gre_word_num=1;
		this.section=section;
		ReadWordClass rdd = new ReadWordClass();
		String flenm= "C:/Users/ff/Downloads/sec1.txt";
		String []master_w = rdd.read(1, flenm);
		StringArrayToNumberArrayClass nmm = new StringArrayToNumberArrayClass();
		master_word_identity = nmm.convetIntoInt(master_w);
		
				
				
		createBgPanelMethod();
		createMenuPanelMethod();
		fillupMenuPanelMethod(Word_amount,section);
		createWordPanelMethod();
		createLabelsinWordPanel();
		//createWordMeaningPanelMethod();
		addNextPrevButtonMethod();
		addExitButtonOnMenuPanelMethod();
		addPrevButtonOnBGMethod();
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
	
	private void fillupMenuPanelMethod(int w_num,int sec){
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
				JOptionPane.showMessageDialog(null, "reset done !!");
				reset();
			}
		});
		
		//----------------------------showing number of mastered word-------------------------------
		String filename = "C:/Users/ff/Downloads/mastered.txt";
		rd = new ReadWordClass();
		String []arr1 = rd.read(1, filename);
		//int[] array = Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
		StringArrayToNumberArrayClass nm = new StringArrayToNumberArrayClass();
		array = nm.convetIntoInt(arr1);
		
		JPanel mastered_panel = new JPanel();
		mastered_panel.setLayout(null);
		mastered_panel.setBackground(Color.green);
		mastered_panel.setBounds(10, 300, 200,200);
		option_panel.add(mastered_panel);
		
		JLabel mastered = addLabel(45,0,200,40,"MASTERED",mastered_panel);
		mastered_word_num = addLabel(85,40,200,40,array[sec]+"",mastered_panel);
		JLabel ooff = addLabel(87,80,200,40,"of",mastered_panel);
		JLabel word_num = addLabel(85,120,200,40,w_num+" ",mastered_panel);
		JLabel word = addLabel(60,160,200,40,"\n\n\nWORDS",mastered_panel);
		
		//----------------------------masterder button--------------------------------------------
			
			ButtonClass bt = new ButtonClass();
			btnmaster = bt.createTextButtonOnPanel(170, 580, 300, 25,"master",back_ground);
			btnmaster.setBackground(Color.red);
			btnmaster.setForeground(Color.white);
			btnmaster.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					btnmaster.setBackground(Color.green);
					if(master_word_identity[gre_word_num]==0){
						addMasteredWord();
					}
					master_word_identity[gre_word_num]=1;
				}
			});
			
		///----------------------------important button ------------------------------
			btnimportant = bt.createTextButtonOnPanel(170, 610, 300, 25,"Mark As Important",back_ground);
			btnimportant.setBackground(Color.blue);
			btnimportant.setForeground(Color.white);
			btnimportant.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//btnimportant.setBackground(Color.green);
					addImportantWord();
				}
			});
			
	}
	private void addImportantWord(){
		System.out.println("IMPORTANT");
		
		String filename = "C:/Users/ff/Downloads/ppp.txt";
		ReadWordClass r = new ReadWordClass();
		String [] arr= r.read(gre_word_num,filename);
		
		filename = "C:/Users/ff/Downloads/important.txt";
		String []ar2 = r.read(1, filename);
		boolean flg = true;
		for(int i=0;i<ar2.length;i++){
			if(ar2[i].equals(arr[0])){
				flg=false;
			}
		}
		if(flg==true){
			String []ar3 = new String [ar2.length+1];
			for(int i=0;i<ar2.length;i++){
				ar3[i]=ar2[i];
			}
			ar3[ar2.length]=arr[0];
			//---saving---
			//StringArrayToNumberArrayClass cc = new StringArrayToNumberArrayClass();
			//int []ar4 = cc.convetIntoInt(ar3);
			r.writestr(filename, ar3);
		}
		
		
	}
	private void addMasteredWord(){
		array[section]=array[section]+1;
		mastered_word_num.setText(array[section]+"");
		save();
	}
	private void reset(){
		for(int i=0;i<master_word_identity.length;i++){
			master_word_identity[i]=0;
		}
		array[section]=0;
		mastered_word_num.setText(array[section]+"");
		
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
		if(show_word==-1){
			showMeaningMethod();
		}
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
	
	
	private void createWordPanelMethod(){
		word_panel = new JPanel();
		word_panel.setBounds(40,50,550,400);
		word_panel.setBackground(new Color(1, 0, 1));
		word_panel.setLayout(null);
		back_ground.add(word_panel);
	}
	
	
	private void addNextPrevButtonMethod(){
		ButtonClass btn = new ButtonClass();
		JButton prv_btn = btn.createTextButtonOnPanel(40,455,275,40,"prev: ",back_ground);
		JButton nxt_btn = btn.createTextButtonOnPanel(315,455,275,40,"next: ",back_ground);
		JButton show_hide_button=btn.createTextButtonOnPanel(270,500,80,70,"show",back_ground);
		
		
		prv_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					if(gre_word_num<=1){
						throw new NoWordException("invalid word number");
					}else{
						gre_word_num--;
					}
				}catch(NoWordException ee){
					System.out.println(ee);
				}
				//word.setText(gre_word_num+"");
				hideMeaningMethod();
				showWord();
				showMasteredButton(gre_word_num);
			}
		});
		
		
		nxt_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(total_word_num>gre_word_num) gre_word_num++;
				//word.setText(gre_word_num+"");
				hideMeaningMethod();
				showWord();
				showMasteredButton(gre_word_num);
			}
		});
		
		
		
		show_hide_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				show_word=show_word*-1;
				if(show_word==1){
					hideMeaningMethod();
					showWord();
				}else{
					hideWord();
					showMeaningMethod();
				}
				System.out.println(show_word);
			}
		});
	}
	private void showMasteredButton(int word_num){
		if(master_word_identity[word_num]==1){
			btnmaster.setBackground(Color.green);
		}else{
			btnmaster.setBackground(Color.red);
		}
	}
//	private void addWordLabelinWordPanelMethod(String gre_word){
//		word = addLabel(190,0,500,350,gre_word,word_panel);
//	}
	
	private void showMeaningMethod(){
		String filename = "C:/Users/ff/Downloads/ppp.txt";
		ReadWordClass r = new ReadWordClass();
		String [] arr= r.read(gre_word_num,filename);
		String mean=arr[2];
		try{
			type.setText("type : "+arr[1]);
			if(ban_eng[0]==0) mean=arr[17]+mean;
			if(ban_eng[1]==0) mean=arr[18]+mean;
			meaning1.setText("meaning : "+mean);
			meaning2.setText(arr[3]);
			meaning3.setText(arr[4]);
			meaning4.setText(arr[5]);
			meaning5.setText(arr[6]);
			meaning6.setText(arr[7]);
			
			phrase.setText("phrase : "+arr[8]);
			
			examples1.setText("examples : "+arr[9]);
			examples2.setText(arr[10]);
			
			synonymous.setText("synonymous : "+arr[11]);
			antonymous.setText("antononymous : "+arr[12]);
			
			mnemonics.setText("mnemonics : "+arr[13]);
			
			note1.setText("note : "+arr[14]);
			note2.setText(arr[15]);
			note3.setText(arr[16]); 
		}
		catch(Exception e){
			
		}
	}
	private void hideMeaningMethod(){
		type.setText("");
		
		meaning1.setText("");
		meaning2.setText("");
		meaning3.setText("");
		meaning4.setText("");
		meaning5.setText("");
		meaning6.setText("");
		
		phrase.setText("");
		
		examples1.setText("");
		examples2.setText("");
		
		synonymous.setText("");
		antonymous.setText("");
		
		mnemonics.setText("");
		
		note1.setText("");
		note2.setText("");
		note3.setText(""); 
	}
	private void showWord(){
		String filename = "C:/Users/ff/Downloads/ppp.txt";
		ReadWordClass r = new ReadWordClass();
		String [] arr= r.read(gre_word_num,filename);
		word.setText(arr[0]);
	}
	private void hideWord(){
		word.setText("");
	}
	private void createLabelsinWordPanel(){
		String filename = "C:/Users/ff/Downloads/ppp.txt";
		ReadWordClass r = new ReadWordClass();
		String [] arr= r.read(gre_word_num,filename);
		word = addLabel(190,0,500,350,arr[0],word_panel);
		
		type = addLabel(0,0,500,25,"",word_panel);
		
		meaning1= addLabel(0,25,500,25,"",word_panel);
		meaning2= addLabel(0,50,500,25,"",word_panel);
		meaning3= addLabel(0,75,500,25,"",word_panel);
		meaning4= addLabel(0,100,500,25,"",word_panel);
		meaning5= addLabel(0,125,500,25,"",word_panel);
		meaning6= addLabel(0,150,500,25,"",word_panel);
		
		phrase = addLabel(0,175,500,25,"",word_panel);
		
		examples1 = addLabel(0,200,500,25,"",word_panel);
		examples2 = addLabel(0,225,500,25,"",word_panel);
		
		synonymous = addLabel(0,250,500,25,"",word_panel);
		antonymous = addLabel(0,275,500,25,"",word_panel);
		
		mnemonics = addLabel(0,305,500,25,"",word_panel);
		
		note1 = addLabel(0,325,500,25,"",word_panel);
		note2 = addLabel(0,350,500,25,"",word_panel);
		note3 = addLabel(0,375,500,25,"",word_panel); 
	}
	private JLabel addLabel(int x,int y,int l,int w,String text,JPanel panel){
		Font font = new Font("Serif", Font.ITALIC, 20);
		
		JLabel label = new JLabel();
		label.setText(text);
		label.setFont(font);
		label.setBounds(x,y,l,w);
		label.setForeground(Color.WHITE);
		panel.add(label);
		return label;
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
	private void addPrevButtonOnBGMethod(){
		ImageIcon img = new ImageIcon("D:\\Java-project\\GREWordBook\\src\\images\\back.PNG");
		ButtonClass bt = new ButtonClass();
		JButton prev_btn = bt.createimageButtonInPanel(10, 590, 70, 50, img, back_ground);
		prev_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				WordListClass frame4 = new WordListClass();
				//setVisible(false);
				dispose();
			}
		});
	}
	
}
