package com.excel.onlinemeeting.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
	
//===============post user==========================================================
	
	@Override
	public String saveUser(UserDto dto) {

		if (!userRepository.findByEmail(dto.getEmail()).isPresent()) {
			User dtoToUserEntity = UserUtil.dtoToUserEntity(dto);
			return userRepository.save(dtoToUserEntity).getEmail();
		} else {
			throw new UserExistException("User Already Exist");
		}
	}
	
//===============post meeting==========================================================

	@Override
	public Integer saveMeeting(MeetingDto dto) {

		if (!meetingRepository.findByMeetingId(dto.getMeetingId()).isPresent()) {
			Meeting dtoToMeetingEntity = UserUtil.dtoToMeetingEntity(dto);
			return meetingRepository.save(dtoToMeetingEntity).getMeetingId();
		} else {
			throw new UserExistException("meeting Already Exist");
		}

	}
	
//===============post participants==========================================================

	@Override
	public String saveParticipant(ListOfMeetingParticipantsDto dto) {
		Optional<User> userEmail  = userRepository.findByEmail(dto.getEmail());
		Optional<Meeting> meetingId = meetingRepository.findByMeetingId(dto.getMeetingId());
		if(userEmail.isPresent() && meetingId.isPresent()) {
			 User user = userEmail.get();
			 Meeting meeting = meetingId.get();
			 
			 List<MeetingParticipants> meetingParticipants = dto.getMeetingParticipants().stream()
					 	.map(e -> MeetingParticipants.builder()
					 			.responseStatus(e.getResponseStatus())
					 			.build()).collect(Collectors.toList());
			 
			 if(user.getMeetingParticipants()!=null) {
				 
				 if(!user.getMeetingParticipants().contains(meetingParticipants))
					 user.getMeetingParticipants().addAll(meetingParticipants);
			 }else { 
				 
				 user.setMeetingParticipants(meetingParticipants);
				
			 }if(meeting.getMeetingParticipants()!=null) {
				 
				 if(!meeting.getMeetingParticipants().contains(meetingParticipants))
					 meeting.getMeetingParticipants().addAll(meetingParticipants);

			 }else {
				 
				 meeting.setMeetingParticipants(meetingParticipants);
			 }
			 
			 meetingParticipants.stream().forEach(e -> e.setUser(user));
			 meetingParticipants.stream().forEach(e -> e.setMeeting(meeting));
			 
			 return userRepository.save(user).getEmail();
		 }else
		 
		throw new UserExistException("user not registered!! please register first");
		
		 
		
	}
	
//===============get meeting based on meetingId==========================================================

	@Override
	public MeetingDto getByMeetingId(Integer id) {
	
		try {
			
			Optional<Meeting> optional = meetingRepository.findByMeetingId(id);
			
			if(optional.isPresent()) {
				Meeting meeting = optional.get();
				
				return UserUtil.entityToDto(meeting);
			}
			throw new UserExistException("Meeting Not Found with ID " + id);
		}catch(UserExistException e) {
			throw e;
		}catch(Exception e) {
			throw new UserExistException("Something went wrong while fetching meeting id");
		}
	}
	
//===============get meeting based on meetingDate==========================================================
	
	@Override
	public MeetingDto getByMeetingDate(LocalDate date) {

		try {
			
			Optional<Meeting> optional = meetingRepository.findByDate(date);
			
			if(optional.isPresent()) {
				Meeting meeting = optional.get();
				
				return UserUtil.entityToDto(meeting);
			}
			throw new UserExistException("Meeting Not Found with Date " + date);
		}catch(UserExistException e) {
			throw e;
		}catch(Exception e) {
			throw new UserExistException("Something went wrong while fetching meeting date");
		}
	}
	
//===============update meeting==========================================================

	@Override
	public Integer updateMeeting(MeetingDto dto) {
		
		try {
			Optional<Meeting> optional = meetingRepository.findByMeetingId(dto.getMeetingId());
			if(optional.isPresent()) {
				Meeting meeting	= optional.get();
				Meeting updatedMeeting = UserUtil.updateMeeting(meeting, dto);

				return meetingRepository.save(updatedMeeting).getMeetingId();

			}else
			 throw new UserExistException("Meeting Not Found with MeetingID " + dto.getMeetingId());
			
		}catch(UserExistException e) {
			throw e;
		}catch (Exception e) {
			throw new UserExistException("Something went wrong while updating meeting id");
		}
			
	}
	
//===============delete meeting==========================================================

	@Override
	public String deleteMeeting(MeetingDto dto) {
		
		Optional<Meeting> optional = meetingRepository.findByMeetingId(dto.getMeetingId());
	
		if(optional.isPresent()) {
			Meeting meeting = optional.get();
			 meetingRepository.delete(meeting);
			 return null;
		}else
			throw new UserExistException("Meeting Id not found!!");

	}
	
//===============delete user==========================================================

	@Override
	public String deleteUser(UserDto dto) {
		
		Optional<User> optional = userRepository.findByEmail(dto.getEmail());
		
		if(optional.isPresent()) {
			userRepository.delete(optional.get());
			return null;
		}else
			
			throw new UserExistException("User email not found!!");
	}
	
//===============get all meetings==========================================================

	@Override
	public List<MeetingDto> getAllMeetings() {

			return meetingRepository.findAll().stream()
				.map(e -> MeetingDto.builder()
						.meetingId(e.getMeetingId())
						.title(e.getTitle()).agenda(e.getAgenda())
						.date(e.getDate()).time(e.getTime()).build()).toList();
	
		
	}

//=================adminLogin api=================================================	 
	
	@Override
	public String adminLogin(String email, String password) {
	    Optional<User> userOptional = userRepository.findByEmail(email);
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	   
	        if (password.equals(user.getPassword())) {
	            String role = user.getRole().trim();
	           
	            if ("true".equalsIgnoreCase(role)) {
	                return "Admin Login successful";
	            } else {
	                return "Only admins can login";
	            }
	        } else {
	            return "Invalid email or password";
	        }
	    } else {
	        return "Invalid email or password";
	    }
	}
//=================userLogin api=================================================	 

	@Override
	public String userLogin(String email, String password) {
	    Optional<User> userOptional = userRepository.findByEmail(email);
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	   
	        if (password.equals(user.getPassword())) {
	            String role = user.getRole().trim();
	           
	            if ("false".equalsIgnoreCase(role)) {
	                return "User Login successful";
	            } else {
	                return "Only user can login";
	            }
	        } else {
	            return "Invalid email or password";
	        }
	    } else {
	        return "Invalid email or password";
	    }
	}

	@Override
	public String updatePassword(UserDto dto) {
		
		Optional<User> optional = userRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			User user = optional.get();
			 user.setPassword(dto.getPassword());
			 userRepository.save(user);

			return "Password updated successfully";

		}else
		 throw new UserExistException("Email Not Found " + dto.getEmail());

	}

}
