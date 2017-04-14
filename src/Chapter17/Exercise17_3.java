package Chapter17;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Exercise17_3 {
	public static void main(String[] args){
		long sum = 0;
		try{
			DataInputStream input =
				new DataInputStream(
						new FileInputStream("Exercise17_3.dat"));
			while(true)
				sum += input.readInt();
		}
		catch(EOFException ex){
			System.out.println("All number were read,and"
					+ " the sum of these number is " + sum);
		}
		catch(IOException ex){
			System.out.println("The file does not exist");
		}
	}
}
