package com.demo.aggregator.entity;

import com.demo.aggregator.dto.Vacancy;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * Data model for telegram received vacancies
 */
@Document(collection = "received_vacancies")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class KeyWordReceivedVacancies {

    /**
     * creating a search keyword
     */
    @Id
    private String keyWord;

    /**
     * The map of sent vacancies
     * key The vacancy id
     * value The source id (like rabota.ua)
     */
    private Map<String, Vacancy> receivedVacancy;
}
