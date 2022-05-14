package application;

import entity.ItemEntity;
import entity.StockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.ItemRepository;
import repository.StockRepository;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = {"controller","db"})
@EnableJpaRepositories(basePackageClasses = {ItemRepository.class, StockRepository.class})
@EntityScan(basePackageClasses = {ItemEntity.class, StockEntity.class})
@RestController
@Configuration
public class PhytechApplication {//} extends SpringBootServletInitializer {

    @Autowired
    BuildProperties buildProperties;

    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(PhytechApplication.class);
        SpringApplication application = appBuilder.application();
        application.setAdditionalProfiles("application");
        appBuilder.run(args);
    }

    @GetMapping("/user")
    public String user() {
        return "Fred";
    }


}
