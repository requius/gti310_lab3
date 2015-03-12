package gti310.tp3;

import gti310.tp3.parser.ConcreteParser;
import gti310.tp3.solver.ConcreteSolver;
import gti310.tp3.writer.ConcreteWriter;

/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is façing.
 * 
 * @author François Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * @param <E>
	 * @param <T>
	 * 
	 * @param args The array containing the arguments to the files.
	 */
	public static <E, T> void main(String args[]) {
		System.out.println("Unreal Networks Solver !");
		
		
		
		ConcreteParser<E> concreteParser = new ConcreteParser<E>();
		concreteParser.parse("Vendeur.txt");
		
		
		ConcreteSolver<T, E> solver = new ConcreteSolver<T, E>();
		solver.solve(concreteParser.getTabDepart());
		
		
		ConcreteWriter writer = new ConcreteWriter<T>();
		writer.write(concreteParser.getSommets(), solver);
		
		
	}
	
	
	
	
}
