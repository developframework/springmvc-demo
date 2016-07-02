package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private String firstName;

	private String lastName;

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
