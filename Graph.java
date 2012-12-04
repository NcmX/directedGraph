package gerichteterGraph;

/**@author Frederic Groth, Michael Eckard
 * 
 * **/

import java.util.LinkedList;

public class Graph {
	private int knoten; // Anzahl der Knoten im Graph
	private int kante; // Anzahl der Kanten im Graph
	private boolean gerichtet; // Bool Wert ob der Graph gerichtet ist
	private LinkedList<Integer>[] adjlist; // Adjazenzliste

	public static int[][] wege; // Zweidimensionales Array zur Darstellung in
								// Adjazenzmatrix
	private int[] stelle; // Array zur Darstellung in Adjazenzmatrix

	@SuppressWarnings("unchecked")
	public Graph(int k, boolean g) { // Konstruktor für den Graphen
		knoten = k; // Anzahl Knoten setzen
		gerichtet = g; // Gerichteter/Ungerichteter Graph
		wege = new int[k][k]; // Zweidimensionales Array für Adjazenzmatrix in
								// entsprechender Größe speichern
		kante = 0; // Kante auf 0 da diese über die Klasse Kante implementiert
					// werden
		adjlist = new LinkedList[k]; // Entsprechend der Anzahl der knoten
										// grosse Adjazenzliste erstellen...
		for (int i = 0; i < k; i++)
			// ...und befüllen
			adjlist[i] = new LinkedList<Integer>();
	}

	/* Gibt Anzahl der Knoten zurück */
	public int anzahlKnoten() {
		return knoten;
	}

	/* Gibt Anzahl der Kanten zurück */
	public int anzahlKanten() {
		return kante;
	}

	/* Gibt zurück ob der Graph gerichtet ist */
	public boolean gerichtet() {
		return gerichtet;
	}

	/* Fügt eine Kante vom Typ Kante hinzu */
	public void add(Kante k) {
		adjlist[k.von].add(new Integer(k.nach));
		kante++;
		if (!gerichtet) {
			adjlist[k.nach].add(new Integer(k.von));
			kante++;
		}
	}

	/* Entfernt eine Kante vom Typ Kante */
	public void entf(Kante k) {
		adjlist[k.von].remove(new Integer(k.nach));
		kante--;
		if (!gerichtet) {
			adjlist[k.nach].remove(new Integer(k.von));
			kante--;
		}
	}

	/* Überprüft ob eine Kante "von" - "zu" existiert */
	public boolean isKante(int von, int nach) {
		return adjlist[von].contains(nach);
	}

	/* Gibt Adjazenzliste zurück */
	public LinkedList<Integer> getAdjList(int v) {
		return adjlist[v];
	}

	/* Erstellt die Knoten im Array Stelle für die Adjazenzmatrix */
	public void adjLtoAdjM(Graph g) {
		stelle = new int[this.knoten];

		for (int i = 0; i < g.anzahlKnoten(); i++) {
			stelle[i] = i;
		}

	}

	/* Gibt den Graphen aus der Adjazenzmatrix aus (wege[][] stelle[]) */
	public void adjMAusgeben() {
		for (int j = 0; j < wege.length; j++) {
			for (int i = 0; i < wege[j].length; i++) {
				if (wege[j][i] > 0) {
					System.out.println(stelle[j] + " zu " + stelle[i] + " : "
							+ wege[j][i] + " ");
				}
			}
		}
	}
}