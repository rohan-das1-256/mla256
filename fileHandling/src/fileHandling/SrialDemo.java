package fileHandling;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class SrialDemo {

	public static void main(String[] args) {
		List<PlayersData> data = Arrays.asList(new PlayersData(1, "Kohli", "batsman"),
				new PlayersData(2, "rohit", "batsman"),
				new PlayersData(3, "rahul", "all rounder"));
		
		String path = "players.txt";
		
		try(ObjectOutputStream ow = new ObjectOutputStream(new FileOutputStream(path))) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
