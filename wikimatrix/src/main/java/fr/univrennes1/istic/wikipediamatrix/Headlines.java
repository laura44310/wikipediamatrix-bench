package fr.univrennes1.istic.wikipediamatrix;

import java.io.PrintWriter;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Headlines {

	public void afficheTitreColonnes(Element tableau1, PrintWriter pw,int i) {
		Elements colonnes = tableau1.select("tbody tr");
		Element entete = colonnes.get(0);
		Elements titre = entete.select("th");
		for(Element headline : titre)
		{ 
			pw.write(headline.text()+"	"); 				//le séparateur est une tabulation 
		   
		}
		pw.write("\n");
	}
}
