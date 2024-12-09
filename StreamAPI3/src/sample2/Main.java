package sample2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singer singer1=new Singer("Queen",new String[] {"Bohemian Rhapsody", "We Will Rock You", "Don't Stop Me Now"});
		Singer singer2=new Singer("Nirvana",new String[] {"Smells Like Teen Spirit", "Come as You Are", "Lithium"});
		Singer singer3=new Singer("The Beatles",new String[] {"Hey Jude", "Let It Be", "Yesterday"});
		Singer singer4=new Singer("Metallica",new String[] { "Enter Sandman", "Master of Puppets", "Nothing Else Matters"});
		
		Singer[] rockStars = new Singer[]{singer1, singer2, singer3, singer4};
		 
		List<String> firstSongs = Arrays.stream(rockStars)
                .map(singer -> singer.getSongs()[0]) 
                .sorted() 
                .collect(Collectors.toList());
		System.out.println("First songs by each artist (alphabetically):");
        firstSongs.forEach(System.out::println);
		}
}

class Singer{
	private String name;
	private String[] songs;
	public Singer(String name, String[] songs) {
		super();
		this.name = name;
		this.songs = songs;
	}
	public String getName() {
		return name;
	}
	public String[] getSongs() {
		return songs;
	}
	@Override
	public String toString() {
		return "Singer [name=" + name + ", songs=" + Arrays.toString(songs) + "]";
	}
	
}
