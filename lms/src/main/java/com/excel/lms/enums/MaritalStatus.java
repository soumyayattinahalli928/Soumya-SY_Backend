package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MaritalStatus {
	MARRIED("MARRIED"), UNMARRIED("UNMARRIED"), DEVORCED("DEVORCED");

	private final String maritalStatus;
}
