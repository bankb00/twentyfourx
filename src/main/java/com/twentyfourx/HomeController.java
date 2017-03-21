package com.twentyfourx;

/**
 * Created by Thanawat on 3/10/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class HomeController {
    @RequestMapping("/")
//    @ResponseBody
    public String home() {
        return "index";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(HomeController.class, args);
    }
}