package com.Covid19DataFetch2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class World implements Serializable
{


	private static final long serialVersionUID = 933817104198905519L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Getter
	@Setter
	@Column
	private int cases;

	@Getter
	@Setter
	@Column
	private int deaths;

	@Getter
	@Setter
	@Column
	private int recovered;
	
	/*
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	*/
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Getter
	@Setter
	
	private java.util.Date createDate;
	//private Date createDate;
	
	@Override
	public String toString() {
		
		return "id-> "+id+" | cases-> "+cases+" |+ deaths-> "+deaths+" | recovered-> "+recovered;
	}

}
