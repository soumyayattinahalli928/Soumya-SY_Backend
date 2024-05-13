package com.excel.Online_Meeting_Scheduling.onetomany.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.excel.Online_Meeting_Scheduling.manytomany.entity.Users;
import com.excel.Online_Meeting_Scheduling.manytoone.entity.ChatMessages;
import com.excel.Online_Meeting_Scheduling.manytoone.entity.MeetingInvitations;
import com.excel.Online_Meeting_Scheduling.manytoone.entity.MeetingParticipants;
import com.excel.Online_Meeting_Scheduling.manytoone.entity.MeetingUpdates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Meeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int meeting_id;
	private String title;
	private String agenda;
	private String datetime;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting")
	private List<MeetingParticipants> participants;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting")
	private List<MeetingInvitations> invitations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting")
	private List<MeetingUpdates> updates; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting")
	private List<ChatMessages> chatmessages ; 
}
