package fr.univrennes1.istic.wikipediamatrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StatDocument {

	public ArrayList<String> recupereNomColonnes(String url, String fichier) throws IOException {
		
		Scanner scan = null; 
	    String[] nomCol=null;
	    ArrayList<String> tab= new ArrayList<String>();
	    try { 
	     scan = new Scanner(new BufferedReader(new FileReader(url+fichier),'\t')); 
	     scan.useDelimiter("	"); 
	     nomCol = scan.nextLine().split("\t"); //permet de garder les noms de colonnes
	     for (int i=0; i<nomCol.length; i++) {
	    	 tab.add(nomCol[i]);
	     }
	     
	    } catch (Exception e) { 
	     System.out.println(e); 
	    } 
	    return(tab);
	}
	

	
	
	public Integer recupereNbLignes(String url, String fichier) {
		
		Scanner scan = null; 
	    int lignes = 0; 
	    try { 
	     scan = new Scanner(new BufferedReader(new FileReader(url+fichier),'\t')); 
	     scan.useDelimiter("	"); 
	     while (scan.hasNextLine()) { 
	    	 String InputLine = scan.nextLine(); 
	    	 lignes=lignes+1;  
	     } 
	    } catch (Exception e) { 
	     System.out.println(e); 
	    } 
	    return(lignes);
	}
	
	public int recupereNbColonnes(String url, String fichier) {
		Scanner scan = null;
	    int colonnes = 0; 
	    String InputLine = ""; 
	    try { 
	     scan = new Scanner(new BufferedReader(new FileReader(url+fichier),'\t')); 
	     scan.useDelimiter("	"); 
	     while (scan.hasNextLine()) { 
	      InputLine = scan.nextLine(); 
	      String[] InArray = InputLine.split("\t"); 
	      colonnes = InArray.length; 
	     } 

	    } catch (Exception e) { 
	     System.out.println(e); 
	    } 
	    return(colonnes);
	}


}

