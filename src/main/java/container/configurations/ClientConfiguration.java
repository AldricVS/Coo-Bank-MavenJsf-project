package container.configurations;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import client.Client;
import client.Consultation;
import client.Transfer;
import client.VIPClient;
import client.Withdraw;

@Configuration
public class ClientConfiguration {

	// ======= OPERATIONS =======
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Consultation consultation() {
		return new Consultation();
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Transfer transfer() {
		return new Transfer();
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Withdraw withdraw() {
		return new Withdraw();
	}
	
	// ======= CLIENTS =======
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public VIPClient vipConsultation(Consultation consultation) {
		VIPClient vipClient = new VIPClient();
		vipClient.setOperation(consultation);
		return vipClient;
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public VIPClient vipTransfer(Transfer transfer) {
		VIPClient vipClient = new VIPClient();
		vipClient.setOperation(transfer);
		return vipClient;
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public VIPClient vipWithdraw(Withdraw withdraw) {
		VIPClient vipClient = new VIPClient();
		vipClient.setOperation(withdraw);
		return vipClient;
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Client normalConsultation(Consultation consultation) {
		Client client = new Client();
		client.setOperation(consultation);
		return client;
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Client normalTransfer(Transfer transfer) {
		Client client = new Client();
		client.setOperation(transfer);
		return client;
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Client normalWithdraw(Withdraw withdraw) {
		Client client = new Client();
		client.setOperation(withdraw);
		return client;
	}
}
