package com.excel.onlinemeeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.onlinemeeting.dto.ListOfMeetingParticipantsDto;
import com.excel.onlinemeeting.dto.MeetingDto;
import com.excel.onlinemeeting.dto.UserDto;
import com.excel.onlinemeeting.response.SuccessResponse;
import com.excel.onlinemeeting.service.MeetingService;

import lombok.Builder;

@RestController
@RequestMapping("/onlinemeeting")
public class MeetingAppController {
	
	@Autowired
	private MeetingService meetingService;

	@PostMapping("/saveuser")
	public ResponseEntity<SuccessResponse<String>> postUser(@RequestBody UserDto dto){
		
		String emailId = meetingService.saveUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().data(emailId).message("User Details Saved").isError(false).build());
	}
	
	@PostMapping("/savemeeting")
	public ResponseEntity<SuccessResponse<Integer>> postMeeting(@RequestBody MeetingDto dto){
		
		Integer meetingId = meetingService.saveMeeting(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<Integer>builder().data(meetingId).message("meeting Details Saved").isError(false).build());
	}
	
	@PostMapping("/saveparticipant")
	public ResponseEntity<SuccessResponse<String>> postParticipant(@RequestBody ListOfMeetingParticipantsDto dto ){
		String emailId = meetingService.saveParticipant(dto);
		
		 return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().data(emailId).message("Participants Details Saved").isError(false).build());
		
	}
	
//	@PostMapping("/savemp")
//	public ResponseEntity<SuccessResponse<Integer>> postMeetingAndParticipant(@RequestBody ListOfMeetingParticipantsDto dto ){
//		
//		Integer meetingId = meetingService.saveMeetingAndParticipant(dto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(
//				SuccessResponse.<Integer>builder().data(meetingId).message("meeting id saved").isError(false).build());
//				
//	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<SuccessResponse<MeetingDto>> getByMeetingId(@PathVariable Integer id){
		MeetingDto meetingId = meetingService.getByMeetingId(id);
		return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse.<MeetingDto>builder().data(meetingId).message("Fetched based on meeting Id").isError(false).build());
	}

	@PutMapping("/update")
	public ResponseEntity<SuccessResponse<MeetingDto>> updateEmployee(@RequestBody MeetingDto dto){
		
		MeetingDto updatedMeeting = meetingService.updateMeeting(dto);
		return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse.<MeetingDto>builder().data(updatedMeeting).message("Updated Meeting Details").isError(false).build());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
