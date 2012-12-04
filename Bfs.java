package gerichteterGraph;

/**@author Frederic Groth, Michael Eckard
 * 
 * **/

import java.util.LinkedList;

class BFS {

	/* Methode zur Breitensuche */
	public static void bfs(Graph g, int s) {
		final char WHITE = 0;
		final char GRAY = 1;
		final char BLACK = 2;
		char[] farbe = new char[g.anzahlKnoten()];
		int[] d = new int[g.anzahlKnoten()];
		int[] pi = new int[g.anzahlKnoten()];
		for (int u = 0; u < g.anzahlKnoten(); u++) {
			farbe[u] = WHITE;
			d[u] = -1;
			pi[u] = -1;
		}
		farbe[s] = GRAY;
		d[s] = 0;
		pi[s] = -1;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(new Integer(s));
		while (!q.isEmpty()) {
			int u = q.remove().intValue();
			LinkedList<Integer> l = g.getAdjList(u);
			for (int i = 0; i < l.size(); i++) {
				int v = l.get(i).intValue();
				if (farbe[v] == WHITE) {
					farbe[v] = GRAY;
					d[v] = d[u] + 1;
					pi[v] = u;
					q.add(new Integer(v));
				}
			}
			farbe[u] = BLACK;
			System.out.println("Beendet mit Knoten " + u);
		}
		System.out.println("Entfernung vom Knoten " + s + ":");
		for (int i = 0; i < g.anzahlKnoten(); i++)
			System.out.println("Knoten " + i + ": " + d[i]);
	}
}