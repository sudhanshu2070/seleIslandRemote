package com.example.sele_spring_app.controller;

import com.example.sele_spring_app.exception.InvalidURLException;
import com.example.sele_spring_app.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/searchQuery")
    public String performSearch(@RequestParam String url, @RequestParam String query) {
        if (url == null || url.trim().isEmpty()) {
            throw new InvalidURLException("URL parameter is required.");
        }
        if (query == null || query.trim().isEmpty()) {
            throw new InvalidURLException("Query parameter is required.");
        }
        return searchService.performSearch(url, query);
    }
}
