package com.restful.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "events")
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "participants")
	private String participants;
	
	@Column(name = "eventDate")
	private LocalDateTime eventDate;
	
	
	@ManyToMany
	@JoinTable(name = "events_commissar", joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "eventId"),
	inverseJoinColumns = @JoinColumn(name = "commissar_id", referencedColumnName = "commissarId"))
	private List<Commissar> commissars;
}
