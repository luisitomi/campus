package com.restful.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "commissar")
public class Commissar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commissarId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "typeId")
	private String typeId;
	
	@Column(name = "eventDate")
	private LocalDateTime eventDate;
}
