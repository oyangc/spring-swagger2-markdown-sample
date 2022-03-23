package com.oyangc.swaggersample;


import com.oyangc.swaggersample.swagger2.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomSwagger2
@SpringBootApplication
//@SwaggerDefinition(info = @Info(description = "My API", version = "0.0.1",title = "Swagger"))
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
