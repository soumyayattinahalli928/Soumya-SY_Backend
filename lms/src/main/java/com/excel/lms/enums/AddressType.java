package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AddressType {

	PERMANENT("PERMANENT"), CURRENT("CURRENT");

	private final String addressType;
}
