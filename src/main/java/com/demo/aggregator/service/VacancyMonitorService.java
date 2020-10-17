package com.demo.aggregator.service;


/**
 * Service for continuous vacancies monitoring.
 *
 * @author Dmitriy G
 */
public interface VacancyMonitorService extends MonitorService {
    /**
     * Method for monitoring vacancies from some vendor by default interval
     *
     */
    void monitoring();

    /**
     * Method for monitoring vacancies from some vendor by specified interval
     *
     * @param intervalSeconds Interval in seconds
     */
    void monitoring(Long intervalSeconds);

    /**
     * Method for stop monitoring vacancies
     */
    void stopMonitoring();
}
