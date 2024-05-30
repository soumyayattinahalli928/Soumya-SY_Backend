package com.excel.onlinemeeting.dto;

import com.excel.onlinemeeting.enums.ResponseStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetingParticipantDto {

	private Integer participantId;
	private ResponseStatus responseStatus;
}
