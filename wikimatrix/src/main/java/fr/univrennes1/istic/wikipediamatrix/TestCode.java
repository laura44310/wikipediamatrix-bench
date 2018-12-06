package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

public class TestCode {

	@Test
	public void testReading(String nom) throws Exception {
		 
  
		Reader in = new FileReader("output/html/"+nom+".csv");
		assertNotNull(in);

		CSVParser parser = CSVFormat.TDF.withFirstRecordAsHeader().parse(in);
		assertNotNull(parser);
		assertNotSame(0,parser.getHeaderMap().size());
		assertNotSame(0,parser.getRecords().size());
		//assertEquals(2, parser.getHeaderMap().size()-1);  
		//assertEquals(18, parser.getRecords().size());
		parseFully(parser);
		System.out.println("Tests faits pour la page "+ nom);
		System.out.println();
		
	}
	
	private void parseFully(final CSVParser parser) {
	        for (final Iterator<CSVRecord> records = parser.iterator(); records.hasNext(); ) {
	            records.next();
	        }
	    }
}
