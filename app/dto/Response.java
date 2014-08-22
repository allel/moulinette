package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="RESPUESTA")
public class Response {

	private String operation ;
	
	private Trip trip ; 
	
	private String agency ;
	
	private List<Stop> stop ;

    private String update;

    private String error ;

    @XmlElement(name="ORDEN_TRANSPORTE",type=String.class)
    public List<String> getTransportOrder() {
        return transportOrder;
    }

    public void setTransportOrder(List<String> transportOrder) {
        this.transportOrder = transportOrder;
    }


    private List<String> transportOrder ;

    @XmlElement(name="ERROR")
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }



    @XmlElement(name="ACTUALIZACION")
    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }


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
