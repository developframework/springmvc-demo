package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.domain.Person;
import com.demo.domain.Telephone;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("demo5")
public class ConverterDemoController {

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String postTelephone(@RequestParam Telephone telephone) {
		log.info(telephone.toString());
		return telephone.toString();
	}

	@ResponseBody
	@RequestMapping(value = "person", method = RequestMethod.POST)
	public String postPerson(Person person) {
		log.info(person.toString());
		log.info(person.getTelephone().toString());
		log.info(person.getRegisterTime().toString());
		return person.toString();
	}
}
