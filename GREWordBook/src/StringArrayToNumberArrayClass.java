
public class StringArrayToNumberArrayClass {
	 public  int[] convetIntoInt(String [] str) {
	      int size = str.length;
	      int [] arr = new int [size];
	      for(int i=0; i<size; i++) {
	         arr[i] = Integer.parseInt(str[i]);
	      }
	      return arr;
	   }
}
