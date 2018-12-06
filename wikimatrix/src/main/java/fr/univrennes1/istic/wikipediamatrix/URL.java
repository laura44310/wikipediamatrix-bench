package fr.univrennes1.istic.wikipediamatrix;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class URL {
	
	
	
	public void choixUrl() throws Exception {
		
		Scanner scanner=new Scanner(new File("inputdata/wikiurls.txt"));
		while (scanner.hasNextLine()) {
 
		    String nom = scanner.nextLine();
		    System.out.println(nom);
		    
		    String url = "https://en.wikipedia.org/wiki/"+nom;
			Document doc = Jsoup.connect(url).get();
			Page page=new Page();
			page.affichePage(doc,nom);
			
			TestCode test = new TestCode();
			test.testReading(nom);
		    
 
 
		}
 
		scanner.close();

		
		
		
	}
}
