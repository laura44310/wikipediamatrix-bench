package fr.univrennes1.istic.wikipediamatrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StatDocument {

	public String[] recupereNomColonnes() throws IOException {
		
		Scanner scan = null; 
	    int lignes = 0; 
	    int colonnes = 0; 
	    String InputLine = ""; 
	    String[] nomCol=null;
	    try { 
	     scan = new Scanner(new BufferedReader(new FileReader("output/html/Comparison_of_Canon_EOS_digital_cameras-1.csv"),'\t')); 
	     scan.useDelimiter("	"); 
	     nomCol = scan.nextLine().split("\t"); //permet de garder les noms de colonnes
	   
	     lignes=lignes+1; 					//permet de compter la ligne des titres de colonnes
	     while (scan.hasNextLine()) { 
	      InputLine = scan.nextLine(); 
	      String[] InArray = InputLine.split("\t"); 
	      lignes=lignes+1; 
	      colonnes = InArray.length; 
	     } 

	    } catch (Exception e) { 
	     System.out.println(e); 
	    } 
  
	    return(nomCol);
	}
	
	public int recupereNbLignes() {
		
		Scanner scan = null; 
	    int lignes = 0; 
	    String InputLine = ""; 
	    try { 
	     scan = new Scanner(new BufferedReader(new FileReader("output/html/Comparison_of_Canon_EOS_digital_cameras-1.csv"),'\t')); 
	     scan.useDelimiter("	"); 
	     while (scan.hasNextLine()) { 
	      InputLine = scan.nextLine(); 
	      lignes=lignes+1;  
	     } 

	    } catch (Exception e) { 
	     System.out.println(e); 
	    } 
  
	    return(lignes);
	}
}

