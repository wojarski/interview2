/**
 * (c) 2015 by MassineBoecker GmbH.
 * All rights reserved.
 * Do not change or copy without permission of MassineBoecker GmbH.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package interview.core.conf;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Maciej Wojarski
 *
 */

@Configuration
@EnableJpaRepositories(value = "interview.core.repository")
@EnableTransactionManagement
@EntityScan("interview.core.model")
@ComponentScan("interview.core.service")
@EnableAutoConfiguration
public class CoreConf {

    @Bean
    public JpaDialect jpaDialect() {
        return new HibernateJpaDialect();
    }

    @Bean(name="entityManagerFactory")
    public LocalEntityManagerFactoryBean skinEntityManagerFactory() {
    	return new LocalEntityManagerFactoryBean();
    }
    
}
