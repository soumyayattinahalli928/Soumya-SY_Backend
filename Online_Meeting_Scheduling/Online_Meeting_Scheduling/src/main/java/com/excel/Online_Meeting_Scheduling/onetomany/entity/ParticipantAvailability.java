package com.excel.Online_Meeting_Scheduling.onetomany.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.excel.Online_Meeting_Scheduling.manytoone.entity.MeetingParticipants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ParticipantAvailability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int availability_id;
	private String datetime;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "availability")
	private List<MeetingParticipants> participants;
}
