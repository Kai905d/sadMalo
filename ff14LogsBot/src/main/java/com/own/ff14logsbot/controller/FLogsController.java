package com.own.ff14logsbot.controller;
import com.own.ff14logsbot.service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FLogsController {
    @Autowired
    HttpService httpService;
    @GetMapping("/getSource")
    public Object getHtmlSourceCode(String url){
        return httpService.getHttpSourceByUrl(url);
    }
}
