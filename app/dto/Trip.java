package dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;


@XmlRootElement(name="VIAJE")
public class Trip {
	
	private String tripCode ;
	
	private String tripSequence ;
	
	
	private String data ;

	@XmlTransient
	public String getTripCode() {
		if(data!=null && getData().split("#").length>1)
			tripCode = getData().split("#")[0];
		return tripCode;
	}

	public void setTripCode(String tripCode) {
		this.tripCode = tripCode;
	}

	@XmlTransient
	public String getTripSequence() {
		if(data!=null && getData().split("#").length>1)
			tripSequence = getData().split("#")[1];
		return tripSequence;
	}

	public void setTripSequence(String tripSequence) {
		this.tripSequence = tripSequence;
	}

	@XmlValue
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	

	
	
	
	

}
