package com.excel.onlinemeeting.service;

import com.excel.onlinemeeting.dto.ListOfMeetingParticipantsDto;
import com.excel.onlinemeeting.dto.MeetingDto;
import com.excel.onlinemeeting.dto.UserDto;

public interface MeetingService {

	String saveUser(UserDto dto);

	Integer saveMeeting(MeetingDto dto);

	String saveParticipant(ListOfMeetingParticipantsDto dto);

//	Integer saveMeetingAndParticipant(ListOfMeetingParticipantsDto dto);

	MeetingDto getByMeetingId(Integer id);

	MeetingDto updateMeeting(MeetingDto dto);

}
