package client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractOperation {
	@Id
	@GeneratedValue
	private int id;
	private int serviceTime;

	public AbstractOperation() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public AbstractOperation(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public abstract boolean isUrgent();
}