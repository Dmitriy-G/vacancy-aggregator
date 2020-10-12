package com.demo.aggregator.service;

import com.demo.aggregator.model.core.Vacancy;
import org.json.JSONObject;

/**
 * Service for parsing data from vendors to model
 *
 * @author Dmitriy G
 */
public interface VacanciesParserService {
    /**
     * Parse from JSON to model
     *
     * @param jsonObject
     *        Data in JSON format
     */
    Vacancy parse(JSONObject jsonObject);
}
