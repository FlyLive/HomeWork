package Chapter17;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Exercise17_5 {
	public static void main(String[] args) throws IOException{
		int[] n = {1,2,3,4,5};
		Date date = new Date();
		double d = 5.5;
		
		try(
			DataOutputStream output = new DataOutputStream
				(new FileOutputStream("Exercise17_5.dat"));
		){
			for(int i = 0;i < n.length;i++)
				output.writeInt(n[i]);
			output.writeUTF(date.toString());
			output.writeDouble(d);
		}
	}
}
