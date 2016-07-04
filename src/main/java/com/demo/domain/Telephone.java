package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Telephone {

	/* 区号 */
	private String areaCode;
	/* 号码 */
	private String phone;

	@Override
	public String toString() {
		return areaCode + "-" + phone;
	}
}
