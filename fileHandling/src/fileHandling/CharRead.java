package fileHandling;

import java.io.BufferedReader;
import java.io.FileReader;

public class CharRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(FileReader fr = new FileReader("bytetest.txt");
				BufferedReader br = new BufferedReader(fr)) {
			System.out.println(br.readLine());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
