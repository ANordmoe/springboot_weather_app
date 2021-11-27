package com.tts.weatherapp.controller;

import com.tts.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.tts.weatherapp.domain.Response;


@Controller

public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String getIndex(Model model) {
        Response response = weatherService.getForecast("43210");
        System.out.println("response is:" + response.toString());
        model.addAttribute("data", response);
        return "index";
    }
}
