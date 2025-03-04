package com.cys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.cys.dao")
public class TeamProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamProjectApplication.class, args);
    }

}
