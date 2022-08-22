package util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UtilTestReadFile{

	static String pathRequest = "src/test/resources/";


	public static String readJsonFile(String fileName) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(pathRequest.concat(fileName)));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		return sb.toString();
	}


	
}
