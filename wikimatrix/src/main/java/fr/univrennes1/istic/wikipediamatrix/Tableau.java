package fr.univrennes1.istic.wikipediamatrix;

import java.io.PrintWriter;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Tableau {

	public void afficheTableau(Document doc, PrintWriter pw) {
		//selection des tableaux
		Elements newsHeadlines = doc.getElementsByClass("wikitable");
				
		//selection du tableau numéro 1
		Element tableau1 = newsHeadlines.get(0);
				
		Headlines headlines = new Headlines();
		headlines.afficheTitreColonnes(tableau1, pw);
		
		Lines lines = new Lines();
		lines.affichesLignes(tableau1, pw);
	}
}
