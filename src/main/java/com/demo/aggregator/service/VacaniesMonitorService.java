package com.demo.aggregator.service;

import com.demo.aggregator.model.core.Vendor;

/**
 * Service for continuous vacancies monitoring.
 *
 * @author Dmitriy G
 */
public interface VacaniesMonitorService {
    /**
     * Method for monitoring vacancies from some vendor by default interval
     *
     * @param vendor
     * The vendor of vacancies
     */
    void monitoring(Vendor vendor);

    /**
     * Method for monitoring vacancies from some vendor by specified interval
     *
     * @param vendor
     *        The vendor of vacancies
     *
     * @param intervalMills
     *        Interval il milliseconds
     */
    void monitoring(Vendor vendor, String intervalMills);
}
