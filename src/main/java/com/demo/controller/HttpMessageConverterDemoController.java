package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.domain.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("demo3")
public class HttpMessageConverterDemoController {

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Person postPerson(@RequestBody Person person) {
		log.info(person.toString());
		return person;
	}
}
