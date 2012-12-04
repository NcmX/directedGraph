package gerichteterGraph;

/**@author Frederic Groth, Michael Eckard
 * 
 * **/

import java.util.LinkedList;

class DFS {
	static final char WEISS = 0;
	static final char GRAU = 1;
	static final char SCHWARZ = 2;
	static char[] farbe;
	static int[] pi;
	static int[] d, f;
	static int zeit;

	public static void dfs(Graph g) {
		farbe = new char[g.anzahlKnoten()];
		pi = new int[g.anzahlKnoten()];
		d = new int[g.anzahlKnoten()];
		f = new int[g.anzahlKnoten()];
		for (int u = 0; u < g.anzahlKnoten(); u++) {
			farbe[u] = WEISS;
			pi[u] = -1;
		}
		zeit = 0;
		for (int u = 0; u < g.anzahlKnoten(); u++) {
			if (farbe[u] == WEISS)
				dfs_visit(g, u);
		}
	}

	private static void dfs_visit(Graph g, int u) {
		farbe[u] = GRAU;
		zeit++;
		d[u] = zeit;
		LinkedList<Integer> l = g.getAdjList(u);
		for (int i = 0; i < l.size(); i++) {
			int v = l.get(i).intValue();
			if (farbe[v] == WEISS) {
				pi[v] = u;
				dfs_visit(g, v);
			}
		}
		farbe[u] = SCHWARZ;
		f[u] = ++zeit;
		System.out.println("Beendet mit Knoten " + u);
		System.out.println("d = " + d[u] + ", f = " + f[u]);
	}
}