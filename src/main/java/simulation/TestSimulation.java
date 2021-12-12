package simulation;

import container.SpringContainer;
import persistence.DataInit;

public class TestSimulation {

	public static void main(String[] args) {
		
		Simulation simulation = (Simulation) SpringContainer.getBean("simulation");
		simulation.buildBank();
		simulation.simulate();
		System.out.println(simulation.simulationResults());
		simulation.graphicalResults();
	}
}
