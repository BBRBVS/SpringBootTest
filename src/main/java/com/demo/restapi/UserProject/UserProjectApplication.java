package com.demo.restapi.UserProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"com.demo.*"})
//@EnableMongoRepositories("com.demo.restapi.repository")
public class UserProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProjectApplication.class, args);
	}
}
