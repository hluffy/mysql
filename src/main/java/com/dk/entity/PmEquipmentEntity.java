package com.dk.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class PmEquipmentEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5172510780955512439L;
	private Integer id;
	private String equipmentNo;//设备IMEI号
	private String IMEI;//编码后的IMEI号
	private String ip;//设备访问ip
	private Integer uid;//用户id
	private String alive;//是否上线
	private String aliveTime;//上线/下线时间
	private Integer intervalTime;//数据同步间隔，秒
	private Integer state;//设备状态
	private String dateCreated;//创建时间
	private String dateModified;//修改时间
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
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getAlive() {
		return alive;
	}
	public void setAlive(String alive) {
		this.alive = alive;
	}
	public String getAliveTime() {
		return aliveTime;
	}
	public void setAliveTime(String aliveTime) {
		this.aliveTime = aliveTime;
	}
	public Integer getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(Integer intervalTime) {
		this.intervalTime = intervalTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	

}
