package com.excel.onlinemeeting.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excel.onlinemeeting.dto.ListOfMeetingParticipantsDto;
import com.excel.onlinemeeting.dto.MeetingDto;
import com.excel.onlinemeeting.dto.UserDto;
import com.excel.onlinemeeting.response.SuccessResponse;
import com.excel.onlinemeeting.service.MeetingService;

@CrossOrigin
@RestController
@RequestMapping("/onlinemeeting")
public class MeetingAppController {

	@Autowired
	private MeetingService meetingService;
	
//===============Post User==========================================================

	@PostMapping("/saveuser")
	public ResponseEntity<SuccessResponse<String>> postUser(@RequestBody UserDto dto) {

		String emailId = meetingService.saveUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				SuccessResponse.<String>builder().data(emailId).message("User Details Saved").isError(false).build());
	}
	
//===============Post Meeting==========================================================

	@PostMapping("/savemeeting")
	public ResponseEntity<SuccessResponse<Integer>> postMeeting(@RequestBody MeetingDto dto) {

		Integer meetingId = meetingService.saveMeeting(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<Integer>builder().data(meetingId)
				.message("meeting Details Saved").isError(false).build());
	}
	
//===============Post Participant==========================================================

	@PostMapping("/saveparticipant")
	public ResponseEntity<SuccessResponse<String>> postParticipant(@RequestBody ListOfMeetingParticipantsDto dto) {
		String emailId = meetingService.saveParticipant(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(SuccessResponse.<String>builder().data(emailId)
				.message("Participants Details Saved").isError(false).build());

	}
	
//===============get meeting based on id==========================================================

	@GetMapping("/get/{id}")
	public ResponseEntity<SuccessResponse<MeetingDto>> getByMeetingId(@PathVariable Integer id) {
		MeetingDto meetingId = meetingService.getByMeetingId(id);
		return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse.<MeetingDto>builder().data(meetingId)
				.message("Fetched based on meeting Id").isError(false).build());
	}
	
//===============get all meetings==========================================================
	
	@GetMapping("/getall")
	public ResponseEntity<Object> fetchAllMeetings(){
		
		return ResponseEntity.ok(meetingService.getAllMeetings());
	}
	
//===============get meeting based on date==========================================================

	@GetMapping("/getdate/{date}")
	public ResponseEntity<SuccessResponse<MeetingDto>> getByMeetingDate(@PathVariable LocalDate date) {
		MeetingDto meetingDate = meetingService.getByMeetingDate(date);
		return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse.<MeetingDto>builder().data(meetingDate)
				.message("Fetched based on meeting date").isError(false).build());
	}
	
//===============update meeting==========================================================

	@PutMapping("/update")
	public ResponseEntity<SuccessResponse<Integer>> updateEmployee(@RequestBody MeetingDto dto) {

		Integer updatedMeeting = meetingService.updateMeeting(dto);
		return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse.<Integer>builder().data(updatedMeeting)
				.message("Updated Meeting Details").isError(false).build());
	}
	
//===============delete meeting==========================================================

	@DeleteMapping("/deletemeeting")
	public String deleteMeeting(@RequestBody MeetingDto dto) {
		meetingService.deleteMeeting(dto);
		return "Meeting Deleted Successfully";
	}
	
//===============delete user==========================================================

	@DeleteMapping("/deleteuser")
	public String deleteUser(@RequestBody UserDto dto) {
		meetingService.deleteUser(dto);
		return " User Details Deleted Successfully";
	}
	
//=================adminLogin api=================================================

	 @PostMapping("/adminlogin")
	    public ResponseEntity<String> login(@RequestBody UserDto dto) {
		  String email = dto.getEmail();
	        String password = dto.getPassword();
	        
	        String message = meetingService.adminLogin(email, password);

	        return ResponseEntity.status(HttpStatus.OK).body(message);
	       
	    }
	 
//=================userLogin api=================================================
	
	 @PostMapping("/userlogin")
	    public ResponseEntity<String> userLoginMethod(@RequestBody UserDto dto) {
		  String email = dto.getEmail();
	        String password = dto.getPassword();
	        
	        String message = meetingService.userLogin(email, password);

	        return ResponseEntity.status(HttpStatus.OK).body(message);
	       
	    }
	 
//====================updatePassword api==========================================
	 
	    @PutMapping("/updatepassword")
	    public ResponseEntity<SuccessResponse<String>> updatePassword(@RequestBody UserDto dto) {
	        	String email = meetingService.updatePassword(dto);
	        	
	        	return ResponseEntity.status(HttpStatus.OK).body(SuccessResponse.<String>builder().data(email)
	    				.message("Password updated successfully").isError(false).build());
	    }
}
