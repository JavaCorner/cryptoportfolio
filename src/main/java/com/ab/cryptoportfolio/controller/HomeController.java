package com.ab.cryptoportfolio.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpit Bhardwaj
 */

@RestController
public class HomeController {
    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map getVersion(){
        Map<String,String> map = new HashMap<>();
        map.put("app-version",appVersion);
        return map;
    }
}
