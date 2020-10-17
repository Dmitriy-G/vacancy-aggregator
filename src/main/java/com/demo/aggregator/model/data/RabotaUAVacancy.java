package com.demo.aggregator.model.data;

import com.demo.aggregator.model.core.Vacancy;
import lombok.*;

import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class RabotaUAVacancy implements Vacancy {
    private String id;
    private String name;
    @EqualsAndHashCode.Exclude private Date date;
    private String cityName;
    private String companyName;
    private String shortDescription;
}
