package fileHandling;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ByteRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(FileInputStream fis = new FileInputStream("bytetest.txt");
				BufferedInputStream bis = new BufferedInputStream(fis)){
			byte[] br = new byte[1024];
			int x = 0;
			while((x = bis.read(br)) != -1) {
				System.out.println(new String(br,0, x));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
