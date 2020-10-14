package com.demo.aggregator.service;

import com.demo.aggregator.model.core.Source;

/**
 * Service for continuous vacancies monitoring.
 *
 * @author Dmitriy G
 */
public interface VacancyMonitorService extends MonitorService<Source> {
    /**
     * Method for monitoring vacancies from some vendor by default interval
     *
     * @param source
     * The source of vacancies
     */
    void monitoring(Source source);

    /**
     * Method for monitoring vacancies from some vendor by specified interval
     *
     * @param source
     *        The source of vacancies
     *
     * @param intervalSeconds
     *        Interval in seconds
     */
    void monitoring(Source source, Long intervalSeconds);
}
