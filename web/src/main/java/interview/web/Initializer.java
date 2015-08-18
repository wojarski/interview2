package interview.web;

import java.sql.SQLException;
import java.util.Arrays;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"interview.web.controller", "interview.web.validation", "interview.core.conf"})

public class Initializer {

	@Bean
	TomcatEmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
		return new TomcatEmbeddedServletContainerFactory();
	} 
    
	
	public static void main(String[] args) {
		System.out.println("Listing beans:");
		ApplicationContext ctx = SpringApplication.run(Initializer.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        try {
			Server webServer = Server.createWebServer("-web,-webAllowOthers,true,-webPort,8082").start();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
