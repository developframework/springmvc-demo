package com.demo.mvc.component;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.util.Assert;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.demo.domain.Person;
import com.demo.mvc.annotation.PersonPrefix;

public class PersonReturnValueHandler implements HandlerMethodReturnValueHandler {

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return returnType.getParameterType() == Person.class;
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
		Assert.isInstanceOf(Person.class, returnValue);
		mavContainer.setRequestHandled(true);
		// 获取方法上的注解
		PersonPrefix annotation = returnType.getMethodAnnotation(PersonPrefix.class);
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		response.setContentType("text/plain;charset=utf-8");
		Person person = (Person) returnValue;
		response.getWriter().write(annotation.value() + " : " + person);
	}

}
