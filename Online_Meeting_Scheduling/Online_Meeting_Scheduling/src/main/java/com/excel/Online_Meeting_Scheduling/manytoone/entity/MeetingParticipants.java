package com.excel.Online_Meeting_Scheduling.manytoone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.excel.Online_Meeting_Scheduling.manytomany.entity.Users;
import com.excel.Online_Meeting_Scheduling.onetomany.entity.Meeting;
import com.excel.Online_Meeting_Scheduling.onetomany.entity.ParticipantAvailability;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MeetingParticipants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int participant_id;
	private String response_status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Meeting meeting;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Users user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "availability_id")
	private ParticipantAvailability availability;
	
	
}
