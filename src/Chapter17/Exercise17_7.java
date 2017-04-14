package Chapter17;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Exercise17_7 {
	public static void main(String[] args)
			throws ClassNotFoundException{
		double sum = 0;
		try(
				ObjectInputStream input = new ObjectInputStream
					(new FileInputStream("Exercise17_6.dat"));
		){
			while(true){
				Loan l = (Loan)input.readObject();
				System.out.print(l.getLoanAmount() + " ");
				sum += l.getLoanAmount();
			}
		}
		catch(EOFException ex){
			System.out.println("All object were read");
		}
		catch(IOException ex){
			System.out.println("The file does not exist");
		}
		
		System.out.println(sum);
	}
}