package com.excel.onlinemeeting.dto;

import jakarta.persistence.Column;
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
public class UserDto {

	private Integer userId;
	private String firstname;
	private String lastname;
	private Long phoneNo;
	private String email;
	private String password;
	private Integer adminId;
	private String role;
}
