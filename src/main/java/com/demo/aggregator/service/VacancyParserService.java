package com.demo.aggregator.service;

import com.demo.aggregator.model.Vacancy;

import java.util.List;

/**
 * Service for parsing data from vendors to model
 *
 * @author Dmitriy G
 */
public interface VacancyParserService {
    /**
     * Parse from JSON to model
     *
     * @param json Data in JSON format
     */
    List<Vacancy> parse(String json);
}
