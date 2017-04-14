package Chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise12_21 {
	public static void main(String[] args) throws Exception{
		File file = new File("SortedStrings.txt");
		ArrayList<String> fileString = new ArrayList<>();
		
		try(
			Scanner input = new Scanner(file);
		){
			while(input.hasNext()){
				fileString.add(input.next());
			}
			
			for(int i = 0;i < fileString.size() - 1;i++){
				if(i > 1 && fileString.get(i).compareTo(fileString.get(i + 1))
						> 0){
					/*String temp = fileString.get(i + 1);
					fileString.add(i,temp);
					fileString.remove(i + 2);*/
					System.out.println(fileString.get(i - 2) + " "
						+ fileString.get(i - 1));
					
				}
			}
			
			input.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("The file of " + file + " "
				+ "does not exist");
		}
	}
}
