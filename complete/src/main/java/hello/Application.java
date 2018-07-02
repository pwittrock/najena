package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@RestController
public class Application {
    @Value("${MESSAGE:Hello_World}")
    private String message;


    @RequestMapping("/")
    public String home() {
        return message;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
