package com.excel.Online_Meeting_Scheduling.manytoone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.excel.Online_Meeting_Scheduling.manytomany.entity.Users;
import com.excel.Online_Meeting_Scheduling.onetomany.entity.Meeting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MeetingInvitations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invitation_id;
	private String invitation_status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Meeting meeting;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Users user;
}
