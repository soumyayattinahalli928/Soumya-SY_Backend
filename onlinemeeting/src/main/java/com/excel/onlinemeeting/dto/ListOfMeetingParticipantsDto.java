package com.excel.onlinemeeting.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListOfMeetingParticipantsDto {
  
	private String email;
	private List<MeetingParticipantDto> meetingParticipants;
	private Integer meetingId;	
}
