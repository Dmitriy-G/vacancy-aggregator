package com.demo.aggregator.model.sources;

import com.demo.aggregator.model.core.Source;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Setter
@Getter
@AllArgsConstructor
public class RabotaUASource implements Source {
    private URL url;
}
