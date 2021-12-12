package simulation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import client.AbstractClient;


/**
 * This class regroups simulation entry parameters.
 */
@Entity
public class SimulationEntry {
	@Id
	@GeneratedValue
	private int id;
	private int simulationDuration;
	private int cashierCount;
	private int minServiceTime;
	private int maxServiceTime;
	private int clientArrivalInterval;
	private double priorityClientRate;
	private int clientPatienceTime;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = AbstractClient.class)
	private List<AbstractClient> allClients = new ArrayList<AbstractClient>();

	public SimulationEntry() {

	}

	public SimulationEntry(int simulationDuration, int cashierCount, int minServiceTime, int maxServiceTime,
			int clientArrivalInterval, double priorityClientRate, int clientPatienceTime) {
		this.simulationDuration = simulationDuration;
		this.cashierCount = cashierCount;
		this.minServiceTime = minServiceTime;
		this.maxServiceTime = maxServiceTime;
		this.clientArrivalInterval = clientArrivalInterval;
		this.priorityClientRate = priorityClientRate;
		this.clientPatienceTime = clientPatienceTime;
	}

	public int getSimulationDuration() {
		return simulationDuration;
	}

	public void setSimulationDuration(int simulationDuration) {
		this.simulationDuration = simulationDuration;
	}

	public int getCashierCount() {
		return cashierCount;
	}

	public void setCashierCount(int cashierCount) {
		this.cashierCount = cashierCount;
	}

	public int getMinServiceTime() {
		return minServiceTime;
	}

	public void setMinServiceTime(int minServiceTime) {
		this.minServiceTime = minServiceTime;
	}

	public int getMaxServiceTime() {
		return maxServiceTime;
	}

	public void setMaxServiceTime(int maxServiceTime) {
		this.maxServiceTime = maxServiceTime;
	}

	public int getClientArrivalInterval() {
		return clientArrivalInterval;
	}

	public void setClientArrivalInterval(int clientArrivalInterval) {
		this.clientArrivalInterval = clientArrivalInterval;
	}

	public double getPriorityClientRate() {
		return priorityClientRate;
	}

	public void setPriorityClientRate(double priorityClientRate) {
		this.priorityClientRate = priorityClientRate;
	}

	public int getClientPatienceTime() {
		return clientPatienceTime;
	}

	public void setClientPatienceTime(int clientPatienceTime) {
		this.clientPatienceTime = clientPatienceTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<AbstractClient> getAllClients() {
		return allClients;
	}

	public void setAllClients(List<AbstractClient> allClients) {
		this.allClients = allClients;
	}
	
	

}
