package bvp.his.isofhcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class HisIsofhcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(HisIsofhcareApplication.class, args);
    }

}
