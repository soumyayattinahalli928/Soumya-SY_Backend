package com.excel.onlinemeeting.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.onlinemeeting.entity.MeetingParticipants;

public interface ParticipantRepository  extends JpaRepository<MeetingParticipants, Integer>{


}
