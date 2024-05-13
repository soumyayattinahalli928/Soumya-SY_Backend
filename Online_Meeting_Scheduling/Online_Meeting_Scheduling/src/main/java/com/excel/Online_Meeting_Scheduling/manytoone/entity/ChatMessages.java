package com.excel.Online_Meeting_Scheduling.manytoone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class ChatMessages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chat_id;
	private String chat_content;
	private String sent_datetime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Meeting meeting;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Users user;
}
