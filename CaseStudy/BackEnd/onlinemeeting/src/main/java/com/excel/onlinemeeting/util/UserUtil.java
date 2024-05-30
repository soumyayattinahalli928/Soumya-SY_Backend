package com.excel.onlinemeeting.util;

import com.excel.onlinemeeting.dto.MeetingDto;
import com.excel.onlinemeeting.dto.UserDto;
import com.excel.onlinemeeting.entity.Meeting;
import com.excel.onlinemeeting.entity.User;

public class UserUtil {

	public static User dtoToUserEntity(UserDto dto) {
		return User.builder().firstname(dto.getFirstname())
				.lastname(dto.getLastname())
				.phoneNo(dto.getPhoneNo())
				.email(dto.getEmail())
				.password(dto.getPassword())
				
				.role(dto.getRole())
				.build();
	}
	
	public static Meeting dtoToMeetingEntity(MeetingDto dto) {
		return Meeting.builder().title(dto.getTitle())
				.agenda(dto.getAgenda()).date(dto.getDate()).time(dto.getTime()).build();
		
	}
	
	public static MeetingDto entityToDto(Meeting meeting) {
		return MeetingDto.builder()
				.meetingId(meeting.getMeetingId())
				.agenda(meeting.getAgenda())
				.title(meeting.getTitle())
				.date(meeting.getDate())
				.time(meeting.getTime()).build();
	}
	
	public static Meeting updateMeeting(Meeting meeting, MeetingDto dto) {
		meeting.setMeetingId(dto.getMeetingId());
		meeting.setTitle(dto.getTitle());
		meeting.setAgenda(dto.getAgenda());
		meeting.setTime(dto.getTime());
		meeting.setDate(dto.getDate());
		
		return meeting;
		
		
		  
	}
	
}
