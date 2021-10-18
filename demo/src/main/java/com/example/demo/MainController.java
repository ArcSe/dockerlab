package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class MainController {

    private int count = 0;

    @GetMapping("/about")
    public String getAbout() throws UnknownHostException {
        String name = "Iuliia Zhukova";
        String hostName = InetAddress.getLocalHost().getHostName();

        return String.format("<html>\n" +
                "<head></head>\n" +
                "    <body>\n" +
                "        <h3>Hello, %s!</h3>\n" +
                "        <b>Hostname:</b> %s<br/>\n" +
                "    </body>\n" +
                "</html>", name,hostName);
    }

    @GetMapping("/stat")
    public String getSTat()  {
        int countToReturn = count++;
        return Integer.toString(countToReturn);
    }

    @GetMapping("/")
    public String getHome()  {
        return Integer.toString(count);
    }
}
