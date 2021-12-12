package persistence;

import java.io.Serializable;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import client.*;
import simulation.SimulationEntry;
import simulation.StatisticManager;

public class HibernatePersistence implements StatisticPersistence {

	@Override
	public int persist(SimulationEntry simulationEntry, StatisticManager statisticManager) {

		Session session = DBConnection.getSession();
		Transaction persistTransaction1 = session.beginTransaction();

		List<AbstractClient> servedClients = statisticManager.getServedClients();
		List<AbstractClient> nonServedClients = statisticManager.getNonServedClients();
		servedClients.addAll(nonServedClients);
		simulationEntry.setAllClients(servedClients);

		Serializable id = session.save(simulationEntry);
		persistTransaction1.commit();

		session.close();
		return (Integer) id;

	}

	@Override
	public int servedClientCount(int simulationEntryId) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from SimulationEntry se where se.id = :id");
		readQuery.setInteger("id", simulationEntryId);
		List result = readQuery.list();
		SimulationEntry entry = (SimulationEntry) result.get(0);
		int count = 0;
		for (AbstractClient client : entry.getAllClients()) {
			if (client.isServed()) {
				count++;
			}
		}
		readTransaction.commit();
		session.close();

		return count;
	}

	@Override
	public int nonServedClientCount(int simulationEntryId) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		Query readQuery = session.createQuery("from SimulationEntry se where se.id = :id");
		readQuery.setInteger("id", simulationEntryId);
		List result = readQuery.list();
		SimulationEntry entry = (SimulationEntry) result.get(0);
		int count = 0;
		for (AbstractClient client : entry.getAllClients()) {
			if (!client.isServed()) {
				count++;
			}
		}
		readTransaction.commit();
		session.close();

		return count;
	}

}
