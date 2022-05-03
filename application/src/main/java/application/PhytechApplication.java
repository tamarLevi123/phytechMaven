package application;

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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("repository")
@ComponentScan(basePackages = "repository")
@EntityScan
public class PhytechApplication extends SpringBootServletInitializer {

    @Autowired
    BuildProperties buildProperties;

    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(PhytechApplication.class);
        SpringApplication application = appBuilder.application();
        application.setAdditionalProfiles("application");
        application.addListeners(new ApplicationPidFileWriter("shutdown.pid"));
        appBuilder.web(WebApplicationType.NONE).run(args);
        System.out.println("fffffooooo!!!!");
    }

}
