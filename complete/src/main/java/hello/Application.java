package hello;

import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Application {
    @Value("${MESSAGE:Hello_World}")
    private String message;

    @Value("${VERSION:unknown}")
    private String version;

    @Value("${BACKEND_SERVICE:}")
    private String backend;

    @RequestMapping("/")
    public String home() {
        // If there is no backend, return the message
        if (Strings.isEmpty(backend)) {
            return version + "\n";
        }

        // If there is a backend, call it
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://" + backend, String.class).trim();
        return message + " [" +  version + "] [" + result + "]\n";

    }

    @RequestMapping("/healthz")
    public String healthz() {
        return "ok";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
