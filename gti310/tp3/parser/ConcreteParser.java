package gti310.tp3.parser;

import gti310.tp3.solver.ConcreteSolver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConcreteParser<E> implements Parser<E> {

	private static Scanner s;
	private Sommet[] sommets;
	private String nbrSommets;
	private String sommetDepart;

	@Override
	public E parse(String filename) {

		try {

			s = new Scanner(new BufferedReader(new FileReader(filename)));

			nbrSommets = s.next();
			sommetDepart = s.next();

			System.out.println("nbr sommet :" + nbrSommets
					+ " sommet de depart :" + sommetDepart);

			sommets = new Sommet[Integer.parseInt(nbrSommets)];
			for (int i = 0; i < sommets.length; i++) {
				sommets[i] = new Sommet("" + (i + 1));
			}

			String tmp = "";

			ArrayList<Noeud> noeuds = new ArrayList<Noeud>();
			String lastSource = null;
			while (s.hasNext()) {

				String source = s.next();
				if (source.equals("$"))
					break;

				String destination = s.next();
				String poid = s.next();

				if (!source.equals(lastSource) && lastSource != null) {
					sommets[Integer.parseInt(lastSource) - 1].noeudAdjacents = noeuds
							.toArray(new Noeud[noeuds.size()]);
					noeuds = new ArrayList<Noeud>();
				}

				noeuds.add(new Noeud(
						sommets[Integer.parseInt(destination) - 1], Integer
								.parseInt(poid)));
				lastSource = source;
			}
			sommets[Integer.parseInt(lastSource) - 1].noeudAdjacents = noeuds
					.toArray(new Noeud[noeuds.size()]);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		return (E) sommets;

	}

	public String getNbrSommets() {
		return nbrSommets;
	}

	public String getSommetDep() {
		return sommetDepart;
	}

	public Sommet getTabDepart() {
		return sommets[Integer.parseInt(sommetDepart) - 1];

	}

	public Sommet[] getSommets() {
		return sommets;
	}

	// only for test
	public void tooString(ConcreteSolver solver) {

		for (Sommet v : sommets) {
			System.out.println("Distance vers " + v + ": " + v.distanceMin);
			List<Sommet> chemin = solver.getCheminPlusCourtVers(v);
			System.out.println("Chemin: " + chemin);
		}

	}

}
