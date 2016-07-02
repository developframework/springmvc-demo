package com.demo.mvc.component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.demo.domain.Person;

public class PersonHttpMessageConverter implements HttpMessageConverter<Person> {

	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		if (clazz == Person.class) {
			if (mediaType == null) {
				return true;
			}
			for (MediaType supportedMediaType : getSupportedMediaTypes()) {
				if (supportedMediaType.includes(mediaType)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		if (clazz == Person.class) {
			if (mediaType == null || MediaType.ALL.equals(mediaType)) {
				return true;
			}
			for (MediaType supportedMediaType : getSupportedMediaTypes()) {
				if (supportedMediaType.isCompatibleWith(mediaType)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		MediaType mediaType = new MediaType("text", "person", Charset.forName("UTF-8"));
		return Collections.singletonList(mediaType);
	}

	@Override
	public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		String content = new String(IOUtils.toByteArray(inputMessage.getBody()));
		String[] strs = content.split("\\s");
		return new Person(strs[0], strs[1]);
	}

	@Override
	public void write(Person person, MediaType mediaType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		String content = person.getFirstName() + " " + person.getLastName();
		IOUtils.write(content, outputMessage.getBody());
	}

}
