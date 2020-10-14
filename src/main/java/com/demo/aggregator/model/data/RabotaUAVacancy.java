package com.demo.aggregator.model.data;

import com.demo.aggregator.model.core.Vacancy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RabotaUAVacancy implements Vacancy {
    private String id;
    private String name;
    private Date date;
    private String cityName;
    private String companyName;
    private String shortDescription;
}
