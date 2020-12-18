package com.Covid19DataFetch2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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
//@Table
@Entity
@Embeddable
public class Country implements Serializable {
	private static final long serialVersionUID = 523668801317648560L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Getter
	@Setter
	//@Id
	// @Column
	private String country; //"country": "USA",

	@Getter
	@Setter
	private int cases; 	//	"cases": 164266,

	@Getter
	@Setter
	// @Column
	private int todayCases;	//	"todayCases": 422,

	@Getter
	@Setter
	// @Column
	private int deaths;	//	"deaths": 3170,

	@Getter
	@Setter
	// @Column
	private int todayDeaths;	//	"todayDeaths": 14,

	@Getter
	@Setter
	// @Column
	private int recovered;  //	"recovered": 5507,

	@Getter
	@Setter
	// @Column
	private int active;  //	"active": 155589,

	@Getter
	@Setter
	// @Column
	private int critical;  //	"critical": 3512,

	@Getter
	@Setter
	// @Column
	private int casesPerOneMillion;  //	"casesPerOneMillion": 496,

	@Getter
	@Setter
	private int deathsPerOneMillion;  //	"deathsPerOneMillion": 10,
	
	@Getter
	@Setter
	private String firstCase;  //	"firstCase": "\nJan 20 "
	
	/*
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	*/
	//@Column
	@Temporal(TemporalType.DATE)
	//@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Getter
	@Setter
	//@Id
	private java.util.Date createDate;
	//private Date createDate;
}
