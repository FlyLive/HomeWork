package Chapter22;

import java.awt.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Exercise22_5 {
	public static void main(String[] args){
		LinkedList<String> linkedList=new LinkedList<String>();
		try (
			DataInputStream input=new DataInputStream(new FileInputStream(new File(args[0])));
		){
			while(input.read() != -1){
				linkedList.add(input.readLine());
			}
			Collections.sort(linkedList);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("¶ÁÈ¡ÎÄ¼þ´íÎó");
		}
		System.out.print(linkedList);
	}

}
