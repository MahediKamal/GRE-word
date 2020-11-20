import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;


public class MainClass {

	public static Integer calculateMasteredWord(){
		String filename = "C:/Users/ff/Downloads/mastered.txt";
		ReadWordClass r = new ReadWordClass();
		String []arr =  r.read(1, filename);
		
		StringArrayToNumberArrayClass cc = new StringArrayToNumberArrayClass();
		int []num = cc.convetIntoInt(arr);
		Integer ret=0;
		for(int i=0;i<num.length;i++){
			ret+=num[i];
		}
		return ret;
	}
	public static void main(String[] args) {
		String filename = "C:/Users/ff/Downloads/day.txt";
		ReadWordClass r = new ReadWordClass();
		String []arr =  r.read(1, filename);
		
		SimpleDateFormat day  = new SimpleDateFormat("MM/dd/yyyy");
		String d = day.toString();
		System.out.println(d);
		if(!arr[0].equals(d)){
			//do stuff
			Integer prv_masterder_num = Integer.parseInt(arr[1]);
			Integer cur_mastered_mum = calculateMasteredWord();
			arr[0]=d;
			Integer dx= (cur_mastered_mum - prv_masterder_num);
			arr[1] = cur_mastered_mum.toString();
			r.writestr(filename, arr);///wrintng current date
			/// updating graph file
			filename = "C:/Users/ff/Downloads/graph.txt";
			String []ar2 =  r.read(1, filename);
			String []ar3 = new String[ar2.length+1];
			for(int i=0;i<ar2.length;i++){
				ar3[i] = ar2[i];
			}ar3[ar2.length] = dx.toString();
			r.writestr(filename, ar3);
			
		}
		
		// TODO Auto-generated method stub
		MenuFrameClass frame1=new MenuFrameClass("disable","enable");
		
		
	}

}
