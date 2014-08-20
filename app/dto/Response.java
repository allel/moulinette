package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="RESPUESTA" )
public class Response {

	
	private String operation ;
	
	private Trip trip ; 
	
	private String agency ;
	
	private List<Stop> stop ;
	
	

	@XmlElement(name="VIAJE",type = Trip.class)
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@XmlAttribute(name="operation")
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@XmlElement(name = "AGENCIA")
	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	@XmlElement(name="PARADA",type=Stop.class)
	public List<Stop> getStop() {
		return stop;
	}

	public void setStop(List<Stop> stop) {
		this.stop = stop;
	}

	
	
	
	
	
	
	
}
