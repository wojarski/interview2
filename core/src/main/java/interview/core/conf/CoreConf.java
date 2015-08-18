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
//@PropertySource("classpath:/core.properties")
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CoreConf {

	public static final String SKIN_PERSISTENCE_UNIT = "skinUnit";
	
    private static final int MAX_IDLE_TIME = 300;

    private static final int MAX_STATEMENTS = 1000;

    private static final int IDLE_CONNECTION_TEST_PERIOD = 300;

    private static final int ACQUIRE_INCREMENT = 5;

    private static final int RETRY_ATTEMPS = 30;

    private static final int MAX_POOL_SIZE = 1000;
    
    @Autowired
    Environment env;
    
    @Bean
    public JpaDialect jpaDialect() {
        return new HibernateJpaDialect();
    }

    @Bean(name="entityManagerFactory")
    public LocalEntityManagerFactoryBean skinEntityManagerFactory() {
    	return new LocalEntityManagerFactoryBean();
    }
    
    /*@Bean
    public JpaTransactionManager transactionManager() throws PropertyVetoException {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(this.skinEntityManagerFactory());

        return transactionManager;
    }

    @Bean(name="entityManagerFactory")
    public EntityManagerFactory skinEntityManagerFactory() {
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setShowSql(new Boolean(env.getProperty("skin.db.showSql")));
        vendorAdapter.setGenerateDdl(new Boolean(env.getProperty("skin.db.generateDdl")));

        final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPersistenceProvider(new HibernatePersistenceProvider());
        factory.setPersistenceUnitName(SKIN_PERSISTENCE_UNIT);
        factory.setJpaProperties(additionalProperties());
        factory.setDataSource(this.skinDataSource());
        factory.afterPropertiesSet();
        factory.setPackagesToScan("com.mbg.skin.model");
        return factory.getObject();
    }
    
	@Bean(name ="dataSource")
    @Primary
    public DataSource skinDataSource() {
        final ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(env.getProperty("skin.db.driver"));
        } catch (final PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(env.getProperty("skin.db.url"));
        dataSource.setInitialPoolSize(0);
        dataSource.setMinPoolSize(0);
        dataSource.setMaxPoolSize(MAX_POOL_SIZE);
        dataSource.setAcquireRetryAttempts(RETRY_ATTEMPS);
        dataSource.setAcquireIncrement(ACQUIRE_INCREMENT);
        dataSource.setIdleConnectionTestPeriod(IDLE_CONNECTION_TEST_PERIOD);
        dataSource.setTestConnectionOnCheckin(true);
        dataSource.setTestConnectionOnCheckout(true);
        dataSource.setPreferredTestQuery("SELECT 1+1");
        dataSource.setMaxStatements(MAX_STATEMENTS);
        dataSource.setMaxIdleTime(MAX_IDLE_TIME);
        dataSource.setUser(env.getProperty("skin.db.user"));
        dataSource.setPassword(env.getProperty("skin.db.password"));

        return dataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.characterEncoding", "utf-8");
        properties.setProperty("hibernate.connection.charSet", "utf-8");
        properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
        return properties;
    }*/
}
