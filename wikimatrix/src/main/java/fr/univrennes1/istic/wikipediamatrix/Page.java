package fr.univrennes1.istic.wikipediamatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.jsoup.nodes.Document;

public class Page {

	public void affichePage(Document doc,String url) throws FileNotFoundException {
		//System.out.println(doc.title());
		//System.out.println();
		
		PrintWriter pw = new PrintWriter(new File("output/html/"+url+".csv"));
		
		Tableau tableau = new Tableau();
		tableau.afficheTableau(doc, pw);
		
		//permet d'écrire dans le CSV 
        pw.close();
        System.out.println("CSV crée pour le premier tableau de la page "+url);
        
	}
}
