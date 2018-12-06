package fr.univrennes1.istic.wikipediamatrix;

import java.io.PrintWriter;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Lines {

	public void affichesLignes(Element tableau1, PrintWriter pw) {
		Elements lignes = tableau1.select("tbody tr");
		
		for (int i=1; i<=lignes.size()-1; i++) {
			Element ligne = lignes.get(i);
			Elements cases = ligne.select("td");
			//System.out.print("le nom des cases de la ligne " + i +" : ");
			for (Element element : cases) {
					// System.out.print(element.text()+"	"); 
					 pw.write(element.text()+"	");
			}
			//System.out.println("");
			//System.out.println("");
			pw.write("\n");
		}
	}
}
