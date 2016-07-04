package com.demo.domain;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonEntity {

	@Value("010-12345")
	private Telephone telephone;
}
