package fileHandling;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ByteWrite {

	public static void main(String[] args) throws Exception {
	
		File file = new File("bytetest.txt");
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		String message = "This is a simple text for testing file i/o on java";
		
		bos.write(message.getBytes());
		bos.flush();
		System.out.println("Done writing");
		
	}

}
