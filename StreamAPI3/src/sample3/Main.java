package sample3;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		       
		        String directoryPath = "D:\\Java 11.09.2024\\StreamAPI3"; 

		       
		        List<String> txtFiles = Arrays.stream(new File(directoryPath).listFiles())
		                .filter(file -> file.isFile() && file.getName().endsWith(".txt"))
		                .map(File::getName)
		                .collect(Collectors.toList());

		        System.out.println("Files with the extension.txt: " + txtFiles);
		    }
		}
	


