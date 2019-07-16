package config;

import java.nio.charset.StandardCharsets;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
/**
 * servlet容器启动的时候，会找到此类并调用onStartUp方法，此类相当于web容器的入口，会代替web.XML文件
 * （1）、在tomcat,(web容器在启动的时候会自己找WebApplicationInitializer接口的实现类，会找到此类并调用onStartUp方法)
 * （2)、为了构造Spring容器
 * （3）、把servletContext交给Spring容器来管理
 * （4）、在servletContext中添加了一个servlet,这是springMVC的核心servlet
 * 		他也是springMVC模式中的C，即控制器
 * 
 * 		以后我们就不写servlet了，写SpringMVC的controller，写好之后，springMVC框架就会用自己的核心控制器进行相应的转发请求
 * @author ASUS
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//--1.构造Spring容器
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		//--2.Spring容器加载配置
		ctx.register(AppConfig.class);
		//--3.Spring容器接管ServletContext应用上下文对象
		ctx.setServletContext(servletContext);
		//--4.添加Servlet(至少添加一个servlet,springMVC框架实现的入口：servlet)
		ServletRegistration.Dynamic servlet = 
				servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
		//--5.添加过滤器（处理字符编码）
		FilterRegistration.Dynamic encodingFilter = 
				servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		encodingFilter.setInitParameter("encoding", String.valueOf(StandardCharsets.UTF_8));
		//必须设置，强制设置编码格式
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.addMappingForUrlPatterns(null, false, "/*");
	}

	
}

















