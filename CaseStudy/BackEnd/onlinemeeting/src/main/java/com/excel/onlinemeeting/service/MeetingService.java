package com.excel.onlinemeeting.service;

import java.time.LocalDate;

import com.excel.onlinemeeting.dto.ListOfMeetingParticipantsDto;
import com.excel.onlinemeeting.dto.MeetingDto;
import com.excel.onlinemeeting.dto.UserDto;

public interface MeetingService {

	String saveUser(UserDto dto);

	Integer saveMeeting(MeetingDto dto);

	String saveParticipant(ListOfMeetingParticipantsDto dto);

	MeetingDto getByMeetingId(Integer id);

	Integer updateMeeting(MeetingDto dto);

	String deleteMeeting(MeetingDto dto);

	MeetingDto getByMeetingDate(LocalDate date);

	String deleteUser(UserDto dto);

	Object getAllMeetings();

	String adminLogin(String email, String password);

	String userLogin(String email, String password);

	String updatePassword(UserDto dto);


}
