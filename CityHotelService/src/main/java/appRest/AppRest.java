package appRest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("appRest")
@ComponentScan("cityHotel")
@SpringBootApplication
public class AppRest {
    public static void main(String[] args) {
        SpringApplication.run(AppRest.class, args);
    }
}


