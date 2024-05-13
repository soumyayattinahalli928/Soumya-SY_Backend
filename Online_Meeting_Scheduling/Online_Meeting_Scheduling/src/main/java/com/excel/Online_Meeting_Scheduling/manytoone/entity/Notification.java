package com.excel.Online_Meeting_Scheduling.manytoone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.excel.Online_Meeting_Scheduling.manytomany.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notification_id;
	private String notification_type;
	private String message;
	private String sent_datetime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Users user;
	
}
