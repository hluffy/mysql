package com.dk.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CfgUrlEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2056982420935670600L;
	private Integer id;
	private String url;//IP�Ͷ˿�
	private String dateCreated;//����ʱ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	

}
