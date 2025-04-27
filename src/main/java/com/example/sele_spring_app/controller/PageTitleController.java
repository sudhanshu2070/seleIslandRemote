package com.example.sele_spring_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sele_spring_app.exception.InvalidURLException;
import com.example.sele_spring_app.service.PageTitleService;

@RestController
public class PageTitleController {

    @Autowired
    private PageTitleService pageTitleService;

    @GetMapping("/getTitle")
    public String getPageTitle(@RequestParam String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new InvalidURLException("URL parameter is required.");
        }
        return pageTitleService.getPageTitle(url);
    }
}