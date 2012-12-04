package gerichteterGraph;

/**
 * @author Frederic Groth, Michael Eckard
 * 
 * **/

public class Kante {
	int von;
	int nach;

	/* Erstellt eine Kante von einem Konten zum anderen */
	Kante(int von, int nach) {
		this.von = von;
		this.nach = nach;
		Graph.wege[von][nach] = 1; // wege[][] für die Adjazenzmatrix befüllen
	}
}