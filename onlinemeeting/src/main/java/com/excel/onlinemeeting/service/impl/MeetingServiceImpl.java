package com.excel.onlinemeeting.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.excel.onlinemeeting.dto.ListOfMeetingParticipantsDto;
import com.excel.onlinemeeting.dto.MeetingDto;
import com.excel.onlinemeeting.dto.UserDto;
import com.excel.onlinemeeting.entity.Meeting;
import com.excel.onlinemeeting.entity.MeetingParticipants;
import com.excel.onlinemeeting.entity.User;
import com.excel.onlinemeeting.exception.ExceptionHandlerClass;
import com.excel.onlinemeeting.exception.UserExistException;
import com.excel.onlinemeeting.repository.MeetingRepository;
import com.excel.onlinemeeting.repository.ParticipantRepository;
import com.excel.onlinemeeting.repository.UserRepository;
import com.excel.onlinemeeting.service.MeetingService;
import com.excel.onlinemeeting.util.UserUtil;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MeetingRepository meetingRepository;
	@Autowired
	private ParticipantRepository participantRepository;
	
	@Override
	public String saveUser(UserDto dto) {

		if (!userRepository.findByEmail(dto.getEmail()).isPresent()) {
			User dtoToUserEntity = UserUtil.dtoToUserEntity(dto);
			return userRepository.save(dtoToUserEntity).getEmail();
		} else {
			throw new UserExistException("User Already Exist");
		}
	}

	@Override
	public Integer saveMeeting(MeetingDto dto) {

		if (!meetingRepository.findByMeetingId(dto.getMeetingId()).isPresent()) {
			Meeting dtoToMeetingEntity = UserUtil.dtoToMeetingEntity(dto);
			return meetingRepository.save(dtoToMeetingEntity).getMeetingId();
		} else {
			throw new UserExistException("meeting Already Exist");
		}

	}

	@Override
	public String saveParticipant(ListOfMeetingParticipantsDto dto) {
		Optional<User> optional  = userRepository.findByEmail(dto.getEmail());
		 if(optional.isPresent()) {
			 User user = optional.get();
			 
			 if(user.getParticipants()!=null) {
				 
				 	List<MeetingParticipants> participants = dto.getMeetingParticipants().stream()
						 	.map(e -> MeetingParticipants.builder()
						 			.responseStatus(e.getResponseStatus())
						 			.build()).collect(Collectors.toList());
				 
				 	user.setParticipants(participants);
				 	participants.stream().forEach(e -> e.setUser(user));
				 	return userRepository.save(user).getEmail();
			 }
			 throw new UserExistException("meetingParticipants Already Exist");
		 }
		 
		throw new UserExistException("user not registered!! please register first");
		
		 
		
	}

//	@Override
//	public Integer saveMeetingAndParticipant(ListOfMeetingParticipantsDto dto) {
//	
//		Optional optional= participantRepository.findByMeetingIdAndUserEmail(dto.getMeetingId(), dto.getEmail());
//		if(optional.isPresent()) {
//			Meeting meeting = optional.get();
//			if(meeting.getParticipants()!=null) {
//				List<MeetingParticipants> participants = dto.getMeetingParticipants().stream()
//					 	.map(e -> MeetingParticipants.builder()
//					 			.responseStatus(e.getResponseStatus())
//					 			.build()).collect(Collectors.toList());
//				
//				meeting.setParticipants(participants);
//				dto.setEmail(dto.getEmail());
//				participants.stream().forEach(x -> x.setMeeting(meeting));
//				return meetingRepository.save(meeting).getMeetingId();
//			}
//			 throw new UserExistException("meetingParticipants Already Exist");
//		 }
//		throw new UserExistException("user not registered!! please register first");
//		
//	}

	@Override
	public MeetingDto getByMeetingId(Integer id) {
	
		try {
			
			Optional<Meeting> optional = meetingRepository.findByMeetingId(id);
			
			if(optional.isPresent()) {
				Meeting meeting = optional.get();
				
				return UserUtil.entityToDto(meeting);
			}
			throw new UserExistException("Employee Not Found with ID " + id);
		}catch(UserExistException e) {
			throw e;
		}catch(Exception e) {
			throw new UserExistException("Something went wrong while fetching employee id");
		}
	}

	@Override
	public MeetingDto updateMeeting(MeetingDto dto) {
		
		try {
			Optional<Meeting> optional = meetingRepository.findByMeetingId(dto.getMeetingId());
			if(optional.isPresent()) {
				Meeting meeting	= optional.get();
				Meeting updatedMeeting = UserUtil.updateMeeting(meeting, dto);
				/*
//				meetingRepository.save(updatedMeeting);
				
				//-------------Akash's Code
				
				Meeting dtoToMeetingEntity = UserUtil.dtoToMeetingEntity(updatedMeeting);
				
				return meetingRepository.save(dtoToMeetingEntity);
				//------------------------
				 * */
				 
			}
			 throw new UserExistException("Meeting Not Found with MeetingID " + dto.getMeetingId());
			
		}catch(UserExistException e) {
			throw e;
		}catch (Exception e) {
			throw new UserExistException("Something went wrong while updating meeting id");
		}
			
	}


	 
	


}
