package fr.univrennes1.istic.wikipediamatrix;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class URL {
	
	
	
	public void choixUrl() throws Exception {
		
		Scanner scanner=new Scanner(new File("inputdata/wikiurls.txt"));
		while (scanner.hasNextLine()) {
 
		    String nom = scanner.nextLine();
		    
		    System.out.println("");
		    System.out.println("Etude de la page "+nom);
		
		    String url = "https://en.wikipedia.org/wiki/"+nom;  			 
			
		    Document doc = null;
		    try{
		    	doc = Jsoup.connect(url).get();
				Page page=new Page();
				page.affichePage(doc,nom);
			
		    }  catch (HttpStatusException e) {  				//permet de gérer les problèmes si l'URL n'existe pas : error 404
		    	System.out.println("L'URL " + url +" n'existe pas");
		    }
		}
		scanner.close();

		
		
		
	}
}
