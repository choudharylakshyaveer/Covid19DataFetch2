package com.Covid19DataFetch2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
//@Table
@Entity
public class CountryList implements Serializable {

	private static final long serialVersionUID = -722984775187698761L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column //(name = "ID", unique = true, nullable = false)
	private Integer id;

	
	@Getter
	@Setter
	@Embedded
	@ElementCollection
	List<Country> countriesList;

}