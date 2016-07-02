package com.demo.mvc.component;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.demo.domain.Person;
import com.demo.mvc.annotation.MultiPerson;

public class MultiPersonArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(MultiPerson.class) && parameter.getParameterType().equals(Person.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		MultiPerson annotation = parameter.getParameterAnnotation(MultiPerson.class);
		String firstName = webRequest.getParameter(annotation.value() + ".first_name");
		String lastName = webRequest.getParameter(annotation.value() + ".last_name");
		return new Person(firstName, lastName);
	}

}
