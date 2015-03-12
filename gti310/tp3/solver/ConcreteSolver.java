package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import gti310.tp3.parser.Sommet;

public class ConcreteSolver<T, E> implements Solver<E, T> {

	@Override
	public T solve(E input) {
		// TODO Auto-generated method stub
		return null;
	}

	public void solve(Sommet source) {

		source.distanceMin = 0.;
		PriorityQueue<Sommet> fileSommet = new PriorityQueue<Sommet>();
		fileSommet.add(source);

		while (!fileSommet.isEmpty()) {
			Sommet u = fileSommet.poll();

			// Visit each edge exiting u
			for (gti310.tp3.parser.Noeud e : u.noeudAdjacents) {
				Sommet v = e.cible;
				double poids = e.poids;
				double distanceVersU = u.distanceMin + poids;
				if (distanceVersU < v.distanceMin) {
					fileSommet.remove(v);

					v.distanceMin = distanceVersU;
					v.precedent = u;
					fileSommet.add(v);
				}
			}
		}
	}

	public static List<Sommet> getCheminPlusCourtVers(Sommet cible) {
		List<Sommet> chemin = new ArrayList<Sommet>();
		for (Sommet sommet = cible; sommet != null; sommet = sommet.precedent)
			chemin.add(sommet);

		Collections.reverse(chemin);
		return chemin;
	}

}
