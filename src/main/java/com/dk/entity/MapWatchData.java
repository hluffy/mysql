package com.dk.entity;

import java.io.Serializable;

public class MapWatchData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5932281560478861944L;
	private Integer id;
	private String IMEI;
	private String Xloc;
	private String Yloc;
	private Integer bat;
	private Integer RSSI;
	private String sos;
	private String watchDate;
	private String createDate;
	private String isPosition;
	private String address;
	private String type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getXloc() {
		return Xloc;
	}
	public void setXloc(String xloc) {
		Xloc = xloc;
	}
	public String getYloc() {
		return Yloc;
	}
	public void setYloc(String yloc) {
		Yloc = yloc;
	}
	public Integer getBat() {
		return bat;
	}
	public void setBat(Integer bat) {
		this.bat = bat;
	}
	public Integer getRSSI() {
		return RSSI;
	}
	public void setRSSI(Integer rSSI) {
		RSSI = rSSI;
	}
	public String getSos() {
		return sos;
	}
	public void setSos(String sos) {
		this.sos = sos;
	}
	public String getWatchDate() {
		return watchDate;
	}
	public void setWatchDate(String watchDate) {
		this.watchDate = watchDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getIsPosition() {
		return isPosition;
	}
	public void setIsPosition(String isPosition) {
		this.isPosition = isPosition;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
