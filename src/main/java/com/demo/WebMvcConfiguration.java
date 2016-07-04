package com.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.demo.mvc.component.StringToUtilDateConverter;
import com.demo.mvc.component.TelephoneConverter;

@SpringBootApplication
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	// @Override
	// protected void addArgumentResolvers(List<HandlerMethodArgumentResolver>
	// argumentResolvers) {
	// // 注册Person的参数分解器
	// argumentResolvers.add(new MultiPersonArgumentResolver());
	// argumentResolvers.add(new PersonArgumentResolver());
	// }
	//
	// @Override
	// protected void extendMessageConverters(List<HttpMessageConverter<?>>
	// converters) {
	// converters.add(new PersonHttpMessageConverter());
	// }
	//
	// @Override
	// protected void
	// addReturnValueHandlers(List<HandlerMethodReturnValueHandler>
	// returnValueHandlers) {
	// returnValueHandlers.add(new PersonReturnValueHandler());
	// }
	//
	// @Override
	// public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
	// RequestMappingHandlerAdapter adapter =
	// super.requestMappingHandlerAdapter();
	// adapter.setWebBindingInitializer(new MyWebBindingInitializer());
	// return adapter;
	// }

	@Override
	public FormattingConversionService mvcConversionService() {
		StringToUtilDateConverter stringToUtilDateConverter = new StringToUtilDateConverter("yyyy-MM-dd HH:mm:ss");
		TelephoneConverter telephoneConverter = new TelephoneConverter();
		FormattingConversionService formattingConversionService = super.mvcConversionService();
		formattingConversionService.addConverter(telephoneConverter);
		formattingConversionService.addConverter(stringToUtilDateConverter);
		return formattingConversionService;
	}
}
