package gerichteterGraph;

/**@author Frederic Groth, Michael Eckard
 * 
 * **/

import java.util.LinkedList;

public interface GraphInterface {

	public int anzahlKnoten();

	public int anzahlKanten();

	public boolean gerichtet();

	public void add(Kante e);

	public void remove(Kante e);

	public boolean edge(int v, int w);

	public LinkedList<Integer> getAdjList(int v);
}
