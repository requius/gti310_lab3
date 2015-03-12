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

		source.minDistance = 0.;
		PriorityQueue<Sommet> fileSommet = new PriorityQueue<Sommet>();
		fileSommet.add(source);

		while (!fileSommet.isEmpty()) {
			Sommet u = fileSommet.poll();

			// Visit each edge exiting u
			for (gti310.tp3.parser.Noeud e : u.adjacencies) {
				Sommet v = e.cible;
				double poids = e.poids;
				double distanceThroughU = u.minDistance + poids;
				if (distanceThroughU < v.minDistance) {
					fileSommet.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					fileSommet.add(v);
				}
			}
		}
	}

	public static List<Sommet> getShortestPathTo(Sommet target) {
		List<Sommet> path = new ArrayList<Sommet>();
		for (Sommet sommet = target; sommet != null; sommet = sommet.previous)
			path.add(sommet);

		Collections.reverse(path);
		return path;
	}

}
