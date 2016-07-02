package com.demo.mvc.component;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.demo.domain.Person;

public class PersonHttpMessageConverterExtendsAbstract extends AbstractHttpMessageConverter<Person> {

	public PersonHttpMessageConverterExtendsAbstract() {
		super(new MediaType("text", "person", Charset.forName("UTF-8")));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		return clazz == Person.class;
	}

	@Override
	protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		String content = new String(IOUtils.toByteArray(inputMessage.getBody()));
		String[] strs = content.split("\\s");
		return new Person(strs[0], strs[1]);
	}

	@Override
	protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		String content = person.getFirstName() + " " + person.getLastName();
		IOUtils.write(content, outputMessage.getBody());
	}

}
