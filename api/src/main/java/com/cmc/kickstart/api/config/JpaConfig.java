package com.cmc.kickstart.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@EnableJpaRepositories(basePackages = {
    "com.cmc.kickstart.api.account.repository",
    "com.cmc.kickstart.api.customer.repository",
    "com.cmc.kickstart.api.queue.repository"
})
@EntityScan(basePackages = {
    "com.cmc.kickstart.model.domain"
})
@Configuration
public class JpaConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
