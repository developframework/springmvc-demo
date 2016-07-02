package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.domain.Person;
import com.demo.mvc.annotation.MultiPerson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("demo1")
public class HandlerMethodArgumentResolverDemoController {

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String addPerson(Person person) {
		log.info(person.toString());
		return person.toString();
	}

	@ResponseBody
	@RequestMapping(value = "multi", method = RequestMethod.POST)
	public String addPerson(@MultiPerson("person1") Person person1, @MultiPerson("person2") Person person2) {
		log.info(person1.toString());
		log.info(person2.toString());
		return person1.toString() + "\n" + person2.toString();
	}

}
