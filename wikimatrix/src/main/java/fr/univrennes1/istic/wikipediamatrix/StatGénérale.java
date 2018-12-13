package fr.univrennes1.istic.wikipediamatrix;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StatGénérale {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> listeNbLignes=new ArrayList<Integer>();
		ArrayList<Integer> listeNbColonnes= new ArrayList<Integer>();
		ArrayList<String> listeNomColonnes =new ArrayList<String>();
		StatDocument doc = new StatDocument();
		String url= "output/html/";

		File repertoire = new File("output/html/");
		String liste[]=repertoire.list();
		for (int i=1; i<liste.length; i++) {
				listeNbLignes.add(doc.recupereNbLignes(url,liste[i]));
				listeNbColonnes.add(doc.recupereNbColonnes(url, liste[i]));
				listeNomColonnes.addAll(doc.recupereNomColonnes(url, liste[i]));
		}
		System.out.println("nombre de fichiers récupérés : "+ listeNbColonnes.size()); 

		//pour faire des stats sur les nombres de colonnes
		int minC=listeNbColonnes.get(0);
		int maxC=listeNbColonnes.get(0);
		int sommeC=0;
		float moyenneC=0;
		float varianceC=0;
		float ecartTypeC=0;
		for (Integer nombre : listeNbColonnes) {
			if (nombre<minC) {
				minC=nombre;
			}
			if (nombre>maxC) {
				maxC=nombre;
			}
			sommeC=sommeC+nombre;
		}
		moyenneC=(float) sommeC/listeNbColonnes.size();
		float sommeTempC=0;
		for (Integer nombre : listeNbColonnes) {
			sommeTempC=sommeTempC+(nombre-moyenneC)*(nombre-moyenneC);
		}
		varianceC=(float) sommeTempC/listeNbColonnes.size();
		ecartTypeC =(float) Math.sqrt(varianceC);
		System.out.println("nombre de colonnes: min "+minC+" max "+maxC+" somme "+sommeC+" moyenne "+moyenneC+" variance "+varianceC+" écrt type "+ecartTypeC);


		//pour faire des stats sur les nombres de lignes
		int minL=listeNbLignes.get(0);
		int maxL=listeNbLignes.get(0);
		int sommeL=0;
		float moyenneL=0;
		float varianceL=0;
		float ecartTypeL=0;
		for (Integer nombre : listeNbLignes) {
			if (nombre<minL) {
				minL=nombre;
			}
			if (nombre>maxL) {
				maxL=nombre;
			}
			sommeL=sommeL+nombre;
		}
		moyenneL=(float) sommeL/listeNbLignes.size();
		float sommeTempL=0;
		for (Integer nombre : listeNbColonnes) {
			sommeTempL=sommeTempL+(nombre-moyenneL)*(nombre-moyenneL);
		}
		varianceL=(float) sommeTempL/listeNbColonnes.size();
		ecartTypeL=(float) Math.sqrt(varianceL);
		System.out.println("nombre de lignes: min "+minL+" max "+maxL+" somme "+sommeL+" moyenne "+moyenneL+" variance "+varianceL+" écart type "+ecartTypeL);

		//pour compter les occurences des titres de colonnes 
		System.out.println("taille de la liste regroupant les noms de colonnes : "+listeNomColonnes.size());
		Collections.sort(listeNomColonnes);  //il faut trier la liste 
		
		//permete de compter le nombre d'occurence de chaque nom de colonnes
		Map<String, Long> couterMap = listeNomColonnes.stream().collect(Collectors.groupingBy(e -> e.toString().toLowerCase(),Collectors.counting()));
	
		//permet de trier par ordre décroissant les noms de colonnes qui apparraissent le plus 
		ValueComparator comparateur = new ValueComparator(couterMap);
		TreeMap<String,Long> mapTriee = new TreeMap<String,Long>(comparateur);
		mapTriee.putAll(couterMap);
		System.out.println("resultat du tri:" + mapTriee);
	}
	
}
