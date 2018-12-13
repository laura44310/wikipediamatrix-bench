package fr.univrennes1.istic.wikipediamatrix;

import java.io.PrintWriter;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Lines {

	public void affichesLignes(Element tableau1, PrintWriter pw) {
		Elements lignes = tableau1.select("tbody tr");
		
		for (int i=1; i<=lignes.size()-1; i++) {
			Element ligne = lignes.get(i);
			
			Elements enTeteDeLigne = null;
			try {									//g�rer les ent�te de lignes -> tableau � double entr�e
				enTeteDeLigne = ligne.select("th");
				for (Element elementEnTete : enTeteDeLigne) {
					pw.write(elementEnTete.text()+"	");
				}
				
				//g�rer les cases classiques 
				Elements cases = ligne.select("td");
				for (Element element : cases) {
						 pw.write(element.text()+"	");
				}
				pw.write("\n");
			}
			catch (Exception e) {
				//g�rer les cases classiques 
				Elements cases = ligne.select("td");
				for (Element element : cases) {						
						 pw.write(element.text()+"	");
				}
				pw.write("\n");
			}	
		}
		
	}
}
