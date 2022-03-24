package com.demo.aggregator.tasks.impl;

import com.demo.aggregator.config.RabotaUASource;
import com.demo.aggregator.config.Source;
import com.demo.aggregator.dto.Vacancy;
import com.demo.aggregator.service.impl.RabotaUAVacancyParserService;
import com.demo.aggregator.service.NotificationHelperService;
import com.demo.aggregator.tasks.Monitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class RabotaUAVacancyMonitor implements Monitor {

    private Source source;
    private RabotaUAVacancyParserService parserService;
    private NotificationHelperService notificationHelperService;

    @Autowired
    public RabotaUAVacancyMonitor(RabotaUASource source, RabotaUAVacancyParserService parserService, NotificationHelperService notificationHelperService) {
        this.source = source;
        this.parserService = parserService;
        this.notificationHelperService = notificationHelperService;
    }

    //TODO: set delay via config
    @Scheduled(fixedDelay = 10000)
    @Override
    public void monitoring(String keyWord) {
        String actualUrl = source.getUrl() + keyWord;
        log.info("Start vacancy monitor for " + actualUrl;
        RestTemplate rest = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>("", source.getHeaders());
        ResponseEntity<String> responseEntity = rest.exchange(actualUrl, HttpMethod.GET, requestEntity, String.class);
        String response = responseEntity.getBody();
        log.info(response);
        List<Vacancy> vacancyList = parserService.parse(response);
        for (Vacancy vacancy: vacancyList) {
            notificationHelperService.sendVacancyToSubscribers(vacancy);
        }
    }
}
