package avs.aldricvs.buisness;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import business.client.Client;
import business.simulation.Bank;
import business.simulation.Cashier;

public class BankTest {

	@Test
	public void findFreeCashier() {
		Bank bank = new Bank(2);
		Cashier freeCashier = bank.getFreeCashier();
		assertNotNull(freeCashier);
	}
	
	@Test
	public void dontFindFreeCashier() {
		Bank bank = new Bank(2);
		bank.getCashiers().forEach(c -> c.setServingClient(new Client()));
		Cashier freeCashier = bank.getFreeCashier();
		assertNull(freeCashier);
	}
}
