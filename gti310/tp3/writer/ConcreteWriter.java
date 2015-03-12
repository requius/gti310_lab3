package gti310.tp3.writer;

import java.util.List;

import gti310.tp3.parser.Sommet;
import gti310.tp3.solver.ConcreteSolver;
import gti310.tp3.solver.Solver;

public class ConcreteWriter<T> implements Writer<T> {

	@Override
	public void write(String filename, T output) {
		// TODO Auto-generated method stub

	}

	public void write(Sommet[] sommets, ConcreteSolver solver) {

		for (Sommet v : sommets) {
			System.out.println("Distance to " + v + ": " + v.minDistance);
			List<Sommet> path = solver.getShortestPathTo(v);
			System.out.println("Path: " + path);
		}

	}

}
