package com.neo.common.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			// 重写父类提供的跨域请求处理的接口
			public void addCorsMappings(CorsRegistry registry) {
				// 添加映射路径
				registry.addMapping("/**")
				// 放行哪些原始域
						.allowedOrigins("*")
						// 是否发送Cookie信息
						.allowCredentials(true)
						// 放行哪些原始域(请求方式)
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						// 放行哪些原始域(头部信息)
						.allowedHeaders("*")
						// 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
						.exposedHeaders("Header1", "Header2");
			}

			@Override
			public void addArgumentResolvers(
					List<HandlerMethodArgumentResolver> arg0) {

			}

			@Override
			public void addFormatters(FormatterRegistry arg0) {

			}

			@Override
			public void addInterceptors(InterceptorRegistry arg0) {

			}

			@Override
			public void addResourceHandlers(ResourceHandlerRegistry arg0) {

			}

			@Override
			public void addReturnValueHandlers(
					List<HandlerMethodReturnValueHandler> arg0) {

			}

			@Override
			public void addViewControllers(ViewControllerRegistry arg0) {

			}

			@Override
			public void configureAsyncSupport(AsyncSupportConfigurer arg0) {

			}

			@Override
			public void configureContentNegotiation(
					ContentNegotiationConfigurer arg0) {

			}

			@Override
			public void configureDefaultServletHandling(
					DefaultServletHandlerConfigurer arg0) {

			}

			@Override
			public void configureHandlerExceptionResolvers(
					List<HandlerExceptionResolver> arg0) {

			}

			@Override
			public void configureMessageConverters(
					List<HttpMessageConverter<?>> arg0) {

			}

			@Override
			public void configurePathMatch(PathMatchConfigurer arg0) {

			}

			@Override
			public void configureViewResolvers(ViewResolverRegistry arg0) {

			}

			@Override
			public void extendHandlerExceptionResolvers(
					List<HandlerExceptionResolver> arg0) {

			}

			@Override
			public void extendMessageConverters(
					List<HttpMessageConverter<?>> arg0) {

			}

			@Override
			public MessageCodesResolver getMessageCodesResolver() {
				return null;
			}

			@Override
			public Validator getValidator() {
				return null;
			}
		};
	}
}
