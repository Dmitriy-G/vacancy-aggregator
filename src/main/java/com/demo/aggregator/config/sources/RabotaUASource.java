package com.demo.aggregator.config.sources;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
public class RabotaUASource implements Source {
    //TODO: get URL from properties file
    private String url = "rabota.ua";
}
