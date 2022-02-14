package com.js.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
public class NoteTaker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nId;
	private String topicName;
	
	@Column(columnDefinition = "TEXT(3000)")
	private String note;
	
	
	public long getnId() {
		return nId;
	}
	public void setnId(long nId) {
		this.nId = nId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public NoteTaker(long nId, String topicName, String note) {
		super();
		this.nId = nId;
		this.topicName = topicName;
		this.note = note;
	}
	public NoteTaker(String topicName, String note) {
		super();
		this.topicName = topicName;
		this.note = note;
	}
	public NoteTaker() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NoteTaker [nId=" + nId + ", topicName=" + topicName + ", note=" + note + "]";
	}
	
	
	
	
	
	
	

}
