package com.demo.mvc.component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class StringToUtilDateConverter implements Converter<String, java.util.Date> {

	private DateFormat df;

	public StringToUtilDateConverter(String pattern) {
		df = new SimpleDateFormat(pattern);
	}

	@Override
	public Date convert(String source) {
		if (StringUtils.hasText(source)) {
			try {
				return df.parse(source);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
