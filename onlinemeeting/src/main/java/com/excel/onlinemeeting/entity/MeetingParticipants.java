
package com.excel.onlinemeeting.entity;


import java.util.List;

import com.excel.onlinemeeting.enums.ResponseStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class MeetingParticipants {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer participantId;
		@Column(nullable = false)
		
		@Enumerated(EnumType.STRING)
		private ResponseStatus responseStatus;
		
		@JoinColumn(name = "meeting_id")
		@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		private Meeting meeting;
		
		@JoinColumn(name = "user_id")
		@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		private User user;

}
