package gti310.tp3.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import gti310.tp3.parser.Sommet;
import gti310.tp3.solver.ConcreteSolver;
import gti310.tp3.solver.Solver;

public class ConcreteWriter<T> implements Writer<T> {

	@Override
	public void write(String filename, T output) {
		// TODO Auto-generated method stub
	}

	public void write(String filename, String depart, Sommet[] sommets, ConcreteSolver solver) {
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			out.write(depart);
			out.newLine();
			
			String destination = "";
			String parent = "";
			int poids = 0;
			
			for (Sommet v : sommets) {
				System.out.println("Distance vers " + v + ": " + v.distanceMin);
				List<Sommet> chemin = solver.getCheminPlusCourtVers(v);
				System.out.println("Chemin: " + chemin);
				
				destination = v.toString();

				if (chemin.size() > 2){
					parent = chemin.get(chemin.size() - 2).toString();
				} else if (chemin.size() == 2){
					parent = depart;
				} else {
					parent = "-" + depart;
				}
				
				poids = (int) v.distanceMin;
				
				out.write(destination + "\t" + parent + "\t" + poids);
				out.newLine();
			}
			out.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
