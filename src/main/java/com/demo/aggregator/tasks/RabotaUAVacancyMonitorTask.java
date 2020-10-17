package com.demo.aggregator.tasks;

import com.demo.aggregator.config.sources.RabotaUASource;
import com.demo.aggregator.config.sources.Source;
import com.demo.aggregator.service.impl.RabotaUAVacancyParserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RabotaUAVacancyMonitorTask implements Runnable {

    private Source source;
    private RabotaUAVacancyParserService parserService;

    @Autowired
    public RabotaUAVacancyMonitorTask(RabotaUASource source, RabotaUAVacancyParserService parserService) {
        this.source = source;
        this.parserService = parserService;
    }

    @Override
    public void run() {
        log.info("Start vacancy monitor for " + source.getUrl());
        RestTemplate rest = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>("", source.getHeaders());
        ResponseEntity<String> responseEntity = rest.exchange(source.getUrl(), HttpMethod.GET, requestEntity, String.class);
        String response = responseEntity.getBody();
        log.info(response);
        parserService.parse(response);
    }
}
