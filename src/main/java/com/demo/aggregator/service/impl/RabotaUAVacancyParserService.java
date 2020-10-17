package com.demo.aggregator.service.impl;

import com.demo.aggregator.model.core.Vacancy;
import com.demo.aggregator.model.data.RabotaUAVacancy;
import com.demo.aggregator.service.VacancyParserService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RabotaUAVacancyParserService implements VacancyParserService {

    @SneakyThrows
    @Override
    public List<Vacancy> parse(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JSONObject jsonObject = new JSONObject(json);
        JSONArray documents = (JSONArray) jsonObject.get("documents");
        List<Vacancy> vacancies = new ArrayList<>();
        for (Object document: documents) {
            JSONObject obj = (JSONObject) document;
            Vacancy vacancy = mapper.readValue(obj.toString(), RabotaUAVacancy.class);
            vacancies.add(vacancy);
        }
        return vacancies;
    }
}