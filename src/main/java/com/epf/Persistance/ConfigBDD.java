package com.epf.Persistance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

@Configuration
public class ConfigBDD {

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("epf");
        dataSource.setPassword("admin");
        dataSource.setServerName("localhost"); // Suppression du ":"
        dataSource.setPort(3306);
        dataSource.setDatabaseName("pvz");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
