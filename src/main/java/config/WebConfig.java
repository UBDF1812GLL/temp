package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
//@EnableWebMvc             //--启动springMVC
public class WebConfig extends WebMvcConfigurationSupport{//使用@EnableWebMvc就不能继承WebMvcConfigurationSupport
	/**
	 * jsp视图解析器的bean
	 */
	@Bean
	public UrlBasedViewResolver setupViewResolver(){
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	
	/*
	 * 配置处理静态资源
	 */
	@Override
		protected void addResourceHandlers(ResourceHandlerRegistry registry) {
			//前者是映射路径，后者是真实路径
			registry.addResourceHandler("/assets/**").addResourceLocations("assets/");
			super.addResourceHandlers(registry);
		}
}
