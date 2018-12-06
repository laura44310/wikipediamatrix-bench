package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest {

	@Test
	public void testUrl() throws IOException {
	Document doc = Jsoup.connect("http://en.wikipedia.org/").get(); //charge la page wiki en doc (html)
	System.out.println(doc.title());
	Elements newsHeadlines = doc.select("#mp-itn b a");  //cherche les éléments qui ont cette signature là 
	//cherche les éléments <mp_itn et dans ceux la <b> et <a 
	for (Element headline : newsHeadlines) {
	  System.out.println("%s\n\t%s "+headline.attr("title")+headline.absUrl("href"));  //sort le titre et href 
	}
	}
	
//	@Test
//	public void testUrlCanon()  throws IOException {
//		String url = "https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras";
//		Document doc = Jsoup.connect(url).get(); 
//		//System.out.println(doc.title());
//		//System.out.println();
//		
//		PrintWriter pw = new PrintWriter(new File("output/html/testCanon.csv"));
//		
//		//selection des tableaux
//		Elements newsHeadlines = doc.select("table");
//		
//		//selection du tableau numéro 1
//		Element tableau1 = newsHeadlines.get(0);
//		
//		//selection des colonnes du tableau 1
//		Elements colonnes = tableau1.select("tbody tr");
//		Element entete = colonnes.get(0);
//		Elements titre = entete.select("th");
//		//System.out.print("le nom des colonnes : ");
//		int compteur=1;
//		for(Element headline : titre)
//		{
//			//System.out.print(headline.text()+"	");//permet d'afficher les noms des 18 colonnes 
//			//System.out.print(headline.text());
//			pw.write(headline.text());
//			if (compteur < titre.size()) {			//compteur va de 1 à taille -1 -> a taille pas de séparateur
//				compteur = compteur +1;
//				pw.write("	");						//le séparateur est une tabulation 
//				//System.out.print(";");
//			}
//			 										
//		   
//		}
//		//System.out.println("");
//		//System.out.println("");
//		pw.write("\n");
//		
//		//selection des lignes du tableau 1
//		Elements lignes = tableau1.select("tbody tr");
//		
//		for (int i=1; i<=lignes.size()-1; i++) {
//			Element ligne = lignes.get(i);
//			Elements cases = ligne.select("td");
//			//System.out.print("le nom des cases de la ligne " + i +" : ");
//			int compteur2=0;
//			for (Element element : cases) {
//					 //System.out.print(element.text());
//					 pw.write(element.text()+"	");
//					 if (compteur2 < cases.size()) {			//compteur va de 1 à taille -1 -> a taille pas de séparateur
//							compteur2 = compteur2 +1;
//							pw.write("	");						//le séparateur est une tabulation 
//							//System.out.print(";");
//						}
//			}
//			//System.out.println("");
//			//System.out.println("");
//			pw.write("\n");
//		}
//		
//		//permet d'écrire dans le CSV 
//        pw.close();
//        System.out.println("done!");
//       
//        
//        
//	} 
	
	@Test
	public void testReading(String nom) throws Exception {
		 
  
		Reader in = new FileReader("output/html/"+nom+".csv");
		assertNotNull(in);

		CSVParser parser = CSVFormat.TDF.withFirstRecordAsHeader().parse(in);
		assertNotNull(parser);
		assertEquals(18, parser.getHeaderMap().size());  //problème car tableau de taille 18 + case vide crée automatiquement car mauvaise génération des séparateurs
		assertEquals(62, parser.getRecords().size());
		parseFully(parser);
		
	}
	
	private void parseFully(final CSVParser parser) {
	        for (final Iterator<CSVRecord> records = parser.iterator(); records.hasNext(); ) {
	            records.next();
	        }
	    }
	
}

