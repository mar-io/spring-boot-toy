package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return "Mario say what!";
    }

    @RequestMapping("/read")
    public String read() {
        return "Now you reading bro. dot vee two.";
    }

    @RequestMapping("/write")
    public String write() {
        return "Now you writing bro. dot vee two";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

