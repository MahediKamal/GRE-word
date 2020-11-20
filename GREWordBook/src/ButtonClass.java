import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.*;

//import com.sun.glass.ui.Cursor;


public class ButtonClass {
	ButtonClass(){
	}
	public JButton createimageButtonInPanel(int x,int y,int w,int h,ImageIcon img,JPanel panel){
		JButton button = new JButton(img);
		button.setBounds(x,y,w,h);
		//button.setCursor(new Cursor(Cursor.CURSOR_CLOSED_HAND));
		panel.add(button);
		return button;
	}
	public JButton createImageButtonAndLabelOnPanel(int bx,int by,int bw,int bh,ImageIcon img,int lx,int ly,int lw,int lh,String text,JPanel panel,JLabel label){
		Font font = new Font("Serif", Font.ITALIC, 19);
		
		int l_height=50,l_width=150;
		int b_height=50,b_width=50;
		int b_x=140,l_x=5;
		
		//JLabel label = new JLabel();
		label.setText(text);
		label.setFont(font);
		label.setBounds(lx, ly, lw, lh);
		label.setForeground(Color.WHITE);
		panel.add(label);
		
		JButton button = new JButton(img);
		button.setBounds(bx,ly,bh,bw);
		panel.add(button);
		return button;
	}
	public JButton createTextButtonOnPanel(int x,int y,int l,int w,String text,JPanel panel){
		JButton button = new JButton(text);
		button.setBounds(x,y,l,w);
		button.setBackground(new Color(1, 1, 1));
		button.setForeground(Color.gray);
		panel.add(button);
		return button;
	}
	public JButton createColorButtonOnPanel(int x,int y,int l,int w,String text,JPanel panel){
		JButton button = new JButton(text);
		button.setBounds(x,y,l,w);
		//button.setBackground(color.);
		panel.add(button);
		return button;
	}
}
