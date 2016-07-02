package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.domain.Person;
import com.demo.mvc.annotation.PersonPrefix;

@Controller
@RequestMapping("demo2")
public class HandlerMethodReturnValueHandlerDemoController {

	@PersonPrefix("rich man")
	@RequestMapping(method = RequestMethod.GET)
	public Person getPerson() {
		Person person = new Person("Bill", "Gates");
		return person;
	}
}
