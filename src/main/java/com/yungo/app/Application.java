package com.yungo.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@MapperScan(basePackages = {"com.yungo.dao"})
@ComponentScan(basePackages = {"com.yungo.controller" ,"com.yungo.exception","com.yungo.service","com.yungo.config"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

/*

		ApplicationContext ctx =  SpringApplication.run(Application.class, args);
		String[] beanNames =  ctx.getBeanDefinitionNames();
*/

		/*System.out.println("所以beanNames个数："+beanNames.length);

		for(String bn:beanNames){

			System.out.println(bn);

		}*/
	}
}
