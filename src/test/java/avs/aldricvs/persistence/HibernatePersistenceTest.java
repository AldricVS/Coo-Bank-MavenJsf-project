package avs.aldricvs.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import business.client.AbstractClient;
import business.client.Client;
import business.client.SimulationEntry;
import business.client.Withdraw;
import business.simulation.Simulation;
import business.simulation.StatisticManager;
import dao.StatisticPersistence;
import persistence.hibernate.HibernatePersistence;

public class HibernatePersistenceTest {
	private static final int CLIENT_ARRIVAL_INTERVAL = 5;
	private static final int MAX_SERVICE_TIME = 20;
	private static final int MIN_SERVICE_TIME = 10;
	private static final int CASHIER_COUNT = 3;
	private static final int SIMULATION_DURATION = 1000;
	private static final double PIORITY_CLIENT_RATE = 0.1;
	private static final int CLIENT_PATIENCE_TIME = 7;
	
	StatisticPersistence persistence = new HibernatePersistence();
	
	private Simulation createSampleSimulation() {
		Simulation simulation = new Simulation();
		SimulationEntry simulationEntry = new SimulationEntry(SIMULATION_DURATION, CASHIER_COUNT, MIN_SERVICE_TIME,
				MAX_SERVICE_TIME, CLIENT_ARRIVAL_INTERVAL, PIORITY_CLIENT_RATE, CLIENT_PATIENCE_TIME);
		StatisticManager manager = new StatisticManager();
		simulation.setSimulationEntry(simulationEntry);
		simulation.setStatisticManager(manager);
		return simulation;
	}

	@Before
	public void createTables() {
		persistence.dataInit();
	}
	
	@Test
	public void saveAndCountClients() {
		int nbNonServed = 10;
		int nbServed = 20;
		Simulation simulation = createSampleSimulation();
		for(int index = 0; index < nbNonServed; index++){
			AbstractClient client = new Client(index, new Withdraw(), 5);
			simulation.getStatisticManager().registerNonServedClient(client);
		}
		for(int index = 0; index < nbServed; index++){
			AbstractClient client = new Client(index, new Withdraw(), 5);
			simulation.getStatisticManager().registerServedClient(client);
		}
		int idEntry = persistence.persist(simulation.getSimulationEntry(), simulation.getStatisticManager());
		assertEquals(persistence.nonServedClientCount(idEntry), nbNonServed);
		assertEquals(persistence.servedClientCount(idEntry), nbServed);
	}
}
