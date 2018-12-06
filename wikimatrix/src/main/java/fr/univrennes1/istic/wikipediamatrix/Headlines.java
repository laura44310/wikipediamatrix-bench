package fr.univrennes1.istic.wikipediamatrix;

import java.io.PrintWriter;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Headlines {

	public void afficheTitreColonnes(Element tableau1, PrintWriter pw) {
		Elements colonnes = tableau1.select("tbody tr");
		Element entete = colonnes.get(0);
		Elements titre = entete.select("th");
		//System.out.print("le nom des colonnes : ");
		for(Element headline : titre)
		{
			//System.out.print(headline.text()+"	");//permet d'afficher les noms des 18 colonnes 
			pw.write(headline.text()+"	"); //l'espace est une tabulation 
		   
		}
		//System.out.println("");
		//System.out.println("");
		pw.write("\n");
	}
}
