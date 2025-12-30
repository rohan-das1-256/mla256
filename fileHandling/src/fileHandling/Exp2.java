package fileHandling;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Exp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> data = Arrays.asList("rohit", "kohli", "pant", "rahul", "bumrah", "bapu");
		String path = "data.txt";
		
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(path))){
			data.stream().forEach(x ->{
				try {
					bw.write(x);
					bw.newLine();
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			});
			
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
