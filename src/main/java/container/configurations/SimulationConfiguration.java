package container.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import simulation.Simulation;
import simulation.SimulationEntry;
import simulation.StatisticManager;

@Configuration
public class SimulationConfiguration {
	private static final int CLIENT_ARRIVAL_INTERVAL = 5;
	private static final int MAX_SERVICE_TIME = 20;
	private static final int MIN_SERVICE_TIME = 10;
	private static final int CASHIER_COUNT = 3;
	private static final int SIMULATION_DURATION = 1000;
	private static final double PIORITY_CLIENT_RATE = 0.1;
	private static final int CLIENT_PATIENCE_TIME = 7;

	@Bean
	public SimulationEntry simulationEntry() {
		return new SimulationEntry(SIMULATION_DURATION,
				CASHIER_COUNT,
				MIN_SERVICE_TIME,
				MAX_SERVICE_TIME,
				CLIENT_ARRIVAL_INTERVAL,
				PIORITY_CLIENT_RATE,
				CLIENT_PATIENCE_TIME);
	}

	@Bean
	public StatisticManager statisticManager() {
		return new StatisticManager();
	}
	
	@Bean
	public Simulation simulation(SimulationEntry simulationEntry, StatisticManager statisticManager) {
		Simulation simulation = new Simulation();
		simulation.setSimulationEntry(simulationEntry);
		simulation.setStatisticManager(statisticManager);
		return simulation;
	}
}
