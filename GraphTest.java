package gerichteterGraph;

/**@author Frederic Groth, Michael Eckard
 * 
 * **/

import java.util.LinkedList;

public class GraphTest {
	public static void main(String[] args) {

		/* Graph aus Folie 111 (ad_t7_v11.pdf) erstellen und testen */
		Graph g = new Graph(8, true);
		g.add(new Kante(0, 3));
		g.add(new Kante(0, 7));
		g.add(new Kante(7, 1));
		g.add(new Kante(1, 3));
		g.add(new Kante(3, 5));
		g.add(new Kante(5, 6));
		g.add(new Kante(5, 4));
		g.add(new Kante(4, 2));

		for (int i = 0; i < g.anzahlKnoten(); i++) {
			System.out.println("Knoten " + i + ":");
			LinkedList<Integer> l = g.getAdjList(i);
			for (int j = 0; j < l.size(); j++)
				System.out.println("Kante an: " + l.get(j).intValue());
		}
		System.out
				.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>BFS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		BFS.bfs(g, 0);
		System.out
				.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DFS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		DFS.dfs(g);
		System.out
				.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>AdjM<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		g.adjLtoAdjM(g);
		g.adjMAusgeben();
	}
}