package com.excel.onlinemeeting.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResponseStatus {

		ACCEPT("ACCEPT"), DECLINE("DECLINE");

		private final String responseStatus ;
}
