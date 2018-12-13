package fr.univrennes1.istic.wikipediamatrix;

import java.io.File;
import java.io.PrintWriter;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Page {

	public void affichePage(Document doc,String nom) throws Exception {
		
		Elements newsHeadlines = doc.getElementsByClass("wikitable sortable"); //ne prend que les tableaux sortables
		if (newsHeadlines.size()==0) {
			System.out.println("! Sur la page "+nom+ " il n'y a pas de tableaux sortables");
		}
		//boucle for pour g�rer si plusieurs tableaux dans une page 
		for (int i=0; i<newsHeadlines.size();i++) {
		int page = i+1;
		PrintWriter pw = new PrintWriter(new File("output/html/"+nom+"-"+page+".csv"));
	
		Tableau tableau = new Tableau();
		tableau.afficheTableau(doc,pw,i,nom);
		
		
		//permet d'�crire dans le CSV 
        pw.close();
        System.out.println("� CSV cr�e pour le tableau num�ro "+page+" de la page "+nom);
        
        
       TestCode test = new TestCode();
       test.testReading(nom,i);      
	}
		
	}
}
