package gti310.tp3.writer;

import java.util.List;

import gti310.tp3.parser.Vertex;
import gti310.tp3.solver.ConcreteSolver;
import gti310.tp3.solver.Solver;

public class ConcreteWriter<T> implements Writer<T>{


	
	
	
	
	
	
	@Override
	public void write(String filename, T output) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void write(Vertex[] sommets, ConcreteSolver solver){
		
		for (Vertex v : sommets)
		{
			System.out.println("Distance to " + v + ": " + v.minDistance);
			List<Vertex> path = solver.getShortestPathTo(v);
			System.out.println("Path: " + path);
		}
		
	}
	

}
