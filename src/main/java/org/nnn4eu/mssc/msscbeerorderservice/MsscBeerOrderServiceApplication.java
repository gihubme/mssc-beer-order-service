package org.nnn4eu.mssc.msscbeerorderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@EnableTransactionManagement
//@EnableJpaRepositories
//        (
//                entityManagerFactoryRef = "entityManagerFactory",
//                transactionManagerRef = "transactionManager")
@SpringBootApplication
public class MsscBeerOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsscBeerOrderServiceApplication.class, args);
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Bean
    public PlatformTransactionManager transactionManager()
    {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
