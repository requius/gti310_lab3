package gti310.tp3.parser;

public class Sommet implements Comparable<Sommet> {

	public final String nom;
	public Noeud[] noeudAdjacents;
	public double distanceMin = Double.POSITIVE_INFINITY;
	public Sommet precedent;

	public Sommet(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom;
	}

	public int compareTo(Sommet autre) {
		return Double.compare(distanceMin, autre.distanceMin);
	}

}
