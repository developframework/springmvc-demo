package com.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@ResponseBody
	@RequestMapping(value = "postDate", method = RequestMethod.POST)
	public String postDate(@RequestParam Date date) {
		log.info(date.toString());
		return date.toString();
	}
}
