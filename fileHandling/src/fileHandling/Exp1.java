package fileHandling;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Exp1 {
	public static void main(String[] args) {
		String path = "bytetest.txt";
		try(Stream<String> lines = Files.lines(Paths.get(path))) {
			
			lines.filter(x -> x.startsWith("T")).map(String::toUpperCase).forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
