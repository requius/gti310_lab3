package gti310.tp3.parser;

public class Sommet implements Comparable<Sommet> {

	public final String nom;
	public Noeud[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Sommet previous;

	public Sommet(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom;
	}

	public int compareTo(Sommet other) {
		return Double.compare(minDistance, other.minDistance);
	}

}
