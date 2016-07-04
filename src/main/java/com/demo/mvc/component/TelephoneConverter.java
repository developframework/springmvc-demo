package com.demo.mvc.component;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.demo.domain.Telephone;

public class TelephoneConverter implements Converter<String, Telephone> {

	@Override
	public Telephone convert(String source) {
		if (StringUtils.hasText(source) && source.matches("^\\d+\\-\\d+$")) {
			String[] strs = source.split("\\-");
			return new Telephone(strs[0], strs[1]);
		}
		return null;
	}

}
