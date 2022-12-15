package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping("/")
    public String index() {
        String style = "<style type='text/css' media='screen'>";
        style += "body { background-color: purple; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); color: orange; font-size: 250%; }";
        style += "</style>";
        
        String message = "Varun Pujari!";
        
        String body = "<body>" + message + "</body>";

        return style + body;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
