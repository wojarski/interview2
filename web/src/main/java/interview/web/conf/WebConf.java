package interview.web.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
//@EnableWebMvc
//@EnableSpringDataWebSupport
//@ComponentScan(basePackages={"com.mbg.skin.controller", "com.mbg.skin.validation"})
public class WebConf {
	
	private static final long MAX_UPLOAD_SIZE = 50000000L;
	
	/*@Bean
	InternalResourceViewResolver resourceResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean(name = "multipartResolver")
	public MultipartResolver multipartResolver() {
		final CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
		return commonsMultipartResolver;
	}

	@Bean
	WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/css/**", "/img/**", "/js/**")
						.addResourceLocations("/css/", "/img/", "/js/");
			}
			@Override
		    public void addViewControllers(ViewControllerRegistry registry) {
		        registry.addViewController("/login").setViewName("page_login");
		        //registry.addViewController("/dologin").setViewName("jsp/manager/page_manager");
		        //registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		    }
		};

		return adapter;
	}*/
}
