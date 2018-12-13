# Projet Wikipedia Matrix 
Crée par Laura Garçonnet étudiante du Master STD

licence: @INSEE2018

## Principe du projet

L’objectif de ce projet est d’extraire des tableaux au format CSV à partir d'une liste de 336 URL de pages Wikipedia. 
 
## Exécution du programme

Pour lancer le programme, il faut aller sur la classe "Main", puis "Run As", "Java Application". 
Das la console, le programme affiche toutes les pages Wikipédia qu'il visite. Pour chacune, il indique soit qu'il n'y a pas de tableaux de type "wikitable sortable", donc aucun fichier CSV sera crée. Soit il affiche qu'un CSV a été crée pour le tableau numéro X de la page concerné. Une fois le CSV crée, des tests sont effectués pour voir si le tableau est valide, s'il ne l'est pas, il est supprimé. 

Pour lancer les résultats statistiques, il faut aller dans la classe "StatGénérale" et lancer la fonction main. Dans la console, le nombre de fichier CSV crées est affiché. Il y a également des données statistiques sur le nombre de colonnes et de lignes, valeurs que j'ai repris dans mon rapport. La console affiche également les noms de colonnes les plus présents et leurs occurences. 

## Maven

Pour pourvoir lancer l'extracteur de tableaux, de nombreuses dépendances Maven ont été rajoutées au fichier "pom.xml". 
```
<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<!-- jsoup HTML parser library @ https://jsoup.org/ -->
			<groupId>org.jsoup</groupId>
			<artifactId>jsoup</artifactId>
			<version>1.11.3</version>
		</dependency>
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-csv</artifactId>
			<version>1.6</version>
		</dependency>
	</dependencies>
``` 
## Architecture 

Pour rendre le code plus compréhensible par d'autres, il est nécessaire de structurer le code. Pour cela j'ai crée différentes classes en partitionnant une page en tableaux, un tableau possèdant un en-tête et des lignes clasiques ... 
Voici le diagramme de classe de l'extracteur. 

![img](https://imgur.com/a/d5vnXcG)

La partie sur les statistiques n'est pas reliée à l'extracteur car elle analyse les CSV crées et ne s'appuie pas sur le code de l'extrateur de tableaux des pages Wikipedia. 
 
