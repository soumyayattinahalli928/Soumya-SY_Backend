package com.excel.onlinemeeting.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetingDto {

	private Integer meetingId;
	private String title;
	private String agenda;
	private LocalDate date;
	private LocalTime time;
}
