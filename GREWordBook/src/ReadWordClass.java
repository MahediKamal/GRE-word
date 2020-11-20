//import com.opencsv.CSVReader;
//import com.opencsv.CSVWriter;
//import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
/**
 *
 * @author HP
 */
public class ReadWordClass {
	public String data;
	public String[] arr;
	public String[] read(int wordNumber,String filename){
		//String filename = "C:/Users/ff/Downloads/ppp.txt";
		File  file = new File(filename);
		try{
			Scanner inp  = new Scanner(file);
			
			for(int i=1;i<=wordNumber;i++){
				data = inp.next();
				//System.out.println(data+ " *");
			}
			data = data.replace('_', ' ');
			arr = data.split(",");
			//System.out.println( arr[2]);
			//List<String> lst = Arrays.asList(arr);
			inp.close();
		}catch(Exception e){
			System.out.println("file not found");
		}
		return arr;
	}
	
	public void write(String filename,int []arr){
			    try {
			      FileWriter myWriter = new FileWriter(filename);
			      String str = arr[0]+"";
			      for(int i=1;i<arr.length;i++){
			    	  str=str+","+arr[i];
			      }
			      System.out.println(str);
			      
			      myWriter.write(str);
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("error in write function");
			    }
	}
	
	public void writestr(String filename,String []arr){
	    try {
	      FileWriter myWriter = new FileWriter(filename);
	      String str = arr[0];
	      for(int i=1;i<arr.length;i++){
	    	  str=str+","+arr[i];
	      }
	      System.out.println(str);
	      
	      myWriter.write(str);
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("error in write function");
	    }
}
	
}
