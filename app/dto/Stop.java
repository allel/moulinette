package dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;


@XmlRootElement(name="PARADA")
public class Stop {

	private String number ;
	
	private String libel ;
	
	private String street ;
	
	private String city ;
	
	private String sequence ;
	
	private String tourCode ;
	
	private String operationType ;
	
	private String pickedUpType ;
	
	private String recipientNumber ;
	
	private String recipientCode ;
	
	private String shipperNumber ;
	
	private String shipperCode ;
	
	private String stopComment ;
	
	private String dateScheduled ;
	
	private String scheduledDepartureTime ;
	
	private String arrivalStopDescription ;
	
	
	private String data ;


	@XmlTransient
	public String getNumber() {
		if(data!=null && data.split("#").length>14)
			number = data.split("#")[0];
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	@XmlTransient
	public String getLibel() {
		if(data!=null && data.split("#").length>14)
			libel = data.split("#")[1];
		return libel;
	}


	public void setLibel(String libel) {
		this.libel = libel;
	}


	@XmlTransient
	public String getStreet() {
		if(data!=null && data.split("#").length>14)
			street = data.split("#")[2];
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	@XmlTransient
	public String getCity() {
		if(data!=null && data.split("#").length>14)
			city = data.split("#")[3];
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@XmlTransient
	public String getSequence() {
		if(data!=null && data.split("#").length>14)
			sequence = data.split("#")[4];
		return sequence;
	}


	public void setSequence(String sequence) {
		this.sequence = sequence;
	}


	@XmlTransient
	public String getTourCode() {
		if(data!=null && data.split("#").length>14)
			tourCode = data.split("#")[5];
		return tourCode;
	}


	public void setTourCode(String tourCode) {
		this.tourCode = tourCode;
	}


	@XmlTransient
	public String getOperationType() {
		if(data!=null && data.split("#").length>14)
			operationType = data.split("#")[6];
		return operationType;
	}


	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}


	@XmlTransient
	public String getPickedUpType() {
		if(data!=null && data.split("#").length>14)
			pickedUpType = data.split("#")[7];
		return pickedUpType;
	}


	public void setPickedUpType(String pickedUpType) {
		this.pickedUpType = pickedUpType;
	}


	@XmlTransient
	public String getRecipientNumber() {
        if(data!=null && data.split("#").length>14)
            recipientNumber = data.split("#")[7];
        return recipientNumber;
	}


	public void setRecipientNumber(String recipientNumber) {
		this.recipientNumber = recipientNumber;
	}


	@XmlTransient
	public String getRecipientCode() {
        if(data!=null && data.split("#").length>14)
            recipientCode = data.split("#")[8];
        return recipientCode;
	}


	public void setRecipientCode(String recipientCode) {
		this.recipientCode = recipientCode;
	}


	@XmlTransient
	public String getShipperNumber() {
        if(data!=null && data.split("#").length>14)
            shipperNumber = data.split("#")[7];
        return shipperNumber;
	}


	public void setShipperNumber(String shipperNumber) {
		this.shipperNumber = shipperNumber;
	}


	@XmlTransient
	public String getShipperCode() {
        if(data!=null && data.split("#").length>14)
            shipperCode = data.split("#")[8];
        return shipperCode;
	}


	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
	}


	@XmlTransient
	public String getStopComment() {
        if(data!=null && data.split("#").length>14)
            stopComment = data.split("#")[9];
        return stopComment;
	}


	public void setStopComment(String stopComment) {
		this.stopComment = stopComment;
	}

	@XmlTransient
	public String getDateScheduled() {
        if(data!=null && data.split("#").length>14)
            dateScheduled = data.split("#")[11];
        return dateScheduled;
	}

	
	public void setDateScheduled(String dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	@XmlTransient
	public String getScheduledDepartureTime() {
        if(data!=null && data.split("#").length>14)
            scheduledDepartureTime = data.split("#")[13];
		return scheduledDepartureTime;
	}


	public void setScheduledDepartureTime(String scheduledDepartureTime) {
		this.scheduledDepartureTime = scheduledDepartureTime;
	}

	@XmlTransient
	public String getArrivalStopDescription() {
        if(data!=null && data.split("#").length>14)
            arrivalStopDescription = data.split("#")[14];
        return arrivalStopDescription;
	}


	public void setArrivalStopDescription(String arrivalStopDescription) {
		this.arrivalStopDescription = arrivalStopDescription;
	}

	@XmlValue
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
	
	
	
}
