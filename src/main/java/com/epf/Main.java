package com.epf;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.epf.Persistance.ConfigBDD;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigBDD.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        
        String sql = "SELECT * FROM map";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            System.out.println(row);
        }
    }
}