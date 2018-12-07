package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jsoup.HttpStatusException;
import org.junit.Assert;
import org.junit.Test;

public class TestCode {

	@Test
	public void testReading(String nom,int i) throws Exception {
		 
		int numero = i+1;
		Reader in = new FileReader("output/html/"+nom+"-"+numero+".csv");
		assertNotNull(in);

		CSVParser parser = null;
		
			try {
				parser = CSVFormat.TDF.withFirstRecordAsHeader().parse(in);
				assertNotNull(parser);
				assertNotSame(0,parser.getHeaderMap().size());
				assertNotSame(0,parser.getRecords().size()+1);
				//assertEquals(2, parser.getHeaderMap().size()-1);  
				//assertEquals(18, parser.getRecords().size());
				parseFully(parser);
				System.out.println("> Tests faits pour le tableau numéro "+numero+ " de la page "+ nom);
				
			} catch(Exception e) {
				System.out.println("Il y a un problème dans le csv");
				File fichier = new File("output/html/"+nom+"-"+numero+".csv");
				fichier.delete();
				System.out.println("Le fichier " + nom+"-"+numero + "a été supprimé car il n'était pas un CSV conforme");
			}
			
			System.out.println();
		
	}
	
	private void parseFully(final CSVParser parser) {
	        for (final Iterator<CSVRecord> records = parser.iterator(); records.hasNext(); ) {
	            records.next();
	        }
	    }
}
