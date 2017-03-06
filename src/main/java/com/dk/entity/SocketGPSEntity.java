package com.dk.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SocketGPSEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6414753880429155393L;
	private Integer id;
	private String equipmentNo;//�����IMEI��
	private String date;//������
	private String Time;//ʱ����
	private String isPosition;//��λ����
	private String latitude;//γ��
	private String longitude;//����
	private String speed;//�ٶ�
	private String direction;//����
	private String altitude;//����
	private String baseStation;//��վ
	private String wifi;//WIFI
	private String elec;//����
	private String gsensor;//���ٶ�
	private String dateCreated;//����ʱ��;
	private String address;//��ַ
	private String latitudeConv;//ת�����γ��
	private String longitdeConv;//ת����ľ���
	private String dateConv;//ת��ʱ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEquipmentNo() {
		return equipmentNo;
	}
	public void setEquipmentNo(String equipmentNo) {
		this.equipmentNo = equipmentNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getIsPosition() {
		return isPosition;
	}
	public void setIsPosition(String isPosition) {
		this.isPosition = isPosition;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getBaseStation() {
		return baseStation;
	}
	public void setBaseStation(String baseStation) {
		this.baseStation = baseStation;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getElec() {
		return elec;
	}
	public void setElec(String elec) {
		this.elec = elec;
	}
	public String getGsensor() {
		return gsensor;
	}
	public void setGsensor(String gsensor) {
		this.gsensor = gsensor;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitudeConv() {
		return latitudeConv;
	}
	public void setLatitudeConv(String latitudeConv) {
		this.latitudeConv = latitudeConv;
	}
	public String getLongitdeConv() {
		return longitdeConv;
	}
	public void setLongitdeConv(String longitdeConv) {
		this.longitdeConv = longitdeConv;
	}
	public String getDateConv() {
		return dateConv;
	}
	public void setDateConv(String dateConv) {
		this.dateConv = dateConv;
	}
	

}
