package Chapter22;

import java.io.*;
import java.util.*;

public class Exercise22_2 {
	public static void main(String[] args){
		Set<String> set=new HashSet<String>();
		try (
			DataInputStream input=new DataInputStream(new FileInputStream(new File("Exercise22_2.dat")));
		) {
			while(input.read() != -1){
				set.add(input.readLine());
			}
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("¶ÁÈ¡ÎÄ¼ş´íÎó");
		}
		System.out.print(set);
	}
}
