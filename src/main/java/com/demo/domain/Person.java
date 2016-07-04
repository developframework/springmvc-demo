package com.demo.domain;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {

	private String firstName;

	private String lastName;

	private Telephone telephone;

	private Date registerTime;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
