package sample1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path path=Paths.get("D:\\Java 11.09.2024\\StreamAPI3\\src\\sample1\\url.txt");
		Path outputFilePath = Paths.get("accessible_urls.txt");
		
		  try (Stream<String> lines = Files.lines(path)) {
	           
	            List<String> accessibleUrls = lines.filter(Main::isURLAccessible)
	                                               .collect(Collectors.toList());

	            
	            Files.write(outputFilePath, accessibleUrls);

	            System.out.println("Filtering is complete. Available URLs are written in 'accessible_urls.txt'.");
	            System.out.println("Available URLs:");
	            accessibleUrls.forEach(System.out::println);
	        } catch (IOException e) {
	            System.err.println("Error: " + e.getMessage());
	        }
	    }
	private static boolean isURLAccessible(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD"); 
            connection.setConnectTimeout(3000); 
            return connection.getResponseCode() == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            return false;
        }
    }
}
	


