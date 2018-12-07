package fr.univrennes1.istic.wikipediamatrix;

import java.io.PrintWriter;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Tableau {

	public void afficheTableau(Document doc, PrintWriter pw,int i,String nom) throws Exception {
		//selection des tableaux
		Elements newsHeadlines = doc.getElementsByClass("wikitable sortable");
				
		//selection du tableau numéro i
		Element tableau_i = newsHeadlines.get(i);
				
		Headlines headlines = new Headlines();
		headlines.afficheTitreColonnes(tableau_i, pw,i);
		
		Lines lines = new Lines();
		lines.affichesLignes(tableau_i, pw);
		
		
	}
}
