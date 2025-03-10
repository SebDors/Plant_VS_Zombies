package com.epf;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.Persistance.ConfigBDD;

@ComponentScan(basePackages = "com.epf")
public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigBDD.class)) {
            JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
            
            String sql = "SELECT * FROM map";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
            System.out.println("\033c"); // Clear console
            for (Map<String, Object> row : rows) {
                System.out.println(row);
            }
        }
    }
}