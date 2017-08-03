package com.yungo.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@MapperScan(basePackages = {"com.yungo.dao"})
@ComponentScan(basePackages = {"com.yungo.controller" ,"com.yungo.exception","com.yungo.service"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}
}
