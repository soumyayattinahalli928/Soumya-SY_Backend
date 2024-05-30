package com.excel.onlinemeeting.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.onlinemeeting.entity.Meeting;
import com.excel.onlinemeeting.entity.User;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

	Optional<Meeting> findByMeetingId(Integer meetingId);
	
	Optional<Meeting> findByDate(LocalDate date);
	
//	Optional<Meeting> deleteByMeetingId(Meeting meeting );
}
