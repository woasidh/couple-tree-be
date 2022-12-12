package com.woasidh.coupletree.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class SpringConfig {

    private final DBConfig dbConfig;

    @Autowired
    public SpringConfig(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder datasourceBuilder = DataSourceBuilder.create();
        datasourceBuilder.url(dbConfig.getUrl());
        datasourceBuilder.username(dbConfig.getUserName());
        datasourceBuilder.password(dbConfig.getPassword());
        datasourceBuilder.driverClassName(dbConfig.getDriverClassName());
        return datasourceBuilder.build();
    }
}
