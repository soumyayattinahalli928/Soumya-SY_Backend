package com.excel.Online_Meeting_Scheduling.manytomany.entity;

import com.excel.Online_Meeting_Scheduling.manytoone.entity.ChatMessages;
import com.excel.Online_Meeting_Scheduling.manytoone.entity.MeetingInvitations;
import com.excel.Online_Meeting_Scheduling.manytoone.entity.MeetingParticipants;
import com.excel.Online_Meeting_Scheduling.manytoone.entity.Notification;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Columns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "user_name", nullable = true)
	private String name;
	
	@Column(name = "user_email", nullable = true)
	private String email;
	
	@Column(name = "user_password", nullable = true)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Roles> role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Notification> notification;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<ChatMessages> chatmessages ; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<MeetingInvitations>  invitations ;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private MeetingParticipants participants;
	
}
