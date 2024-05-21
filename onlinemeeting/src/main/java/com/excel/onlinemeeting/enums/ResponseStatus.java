package com.excel.onlinemeeting.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResponseStatus {

		ACCEPTED("ACCEPTED"), DECLINED("DECLINED"), TENTATIVE("TENTATIVE");

		private final String responseStatus ;
}
