package application;

import controller.StoreController;
import persistence.entity.ItemEntity;
import persistence.entity.StockEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import persistence.repository.ItemRepository;
import persistence.repository.StockRepository;

@SpringBootApplication(scanBasePackageClasses = {StoreController.class/*,ItemRepository.class, StockRepository.class*/})
@EnableJpaRepositories(basePackageClasses = {ItemRepository.class, StockRepository.class})
@EntityScan(basePackageClasses = {ItemEntity.class, StockEntity.class}/*,basePackages = {"persistence/entity"}*/)
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
