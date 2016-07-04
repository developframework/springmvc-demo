package com.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.demo.mvc.component.MyWebBindingInitializer;

@SpringBootApplication
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	// @Override
	// protected void addArgumentResolvers(List<HandlerMethodArgumentResolver>
	// argumentResolvers) {
	//
	// // 注册Person的参数分解器
	// argumentResolvers.add(new MultiPersonArgumentResolver());
	// argumentResolvers.add(new PersonArgumentResolver());
	// }

	// @Override
	// protected void extendMessageConverters(List<HttpMessageConverter<?>>
	// converters) {
	// converters.add(new PersonHttpMessageConverter());
	// }

	// @Override
	// protected void
	// addReturnValueHandlers(List<HandlerMethodReturnValueHandler>
	// returnValueHandlers) {
	// returnValueHandlers.add(new PersonReturnValueHandler());
	// }

	@Override
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter adapter = super.requestMappingHandlerAdapter();
		adapter.setWebBindingInitializer(new MyWebBindingInitializer());
		return adapter;
	}
}
