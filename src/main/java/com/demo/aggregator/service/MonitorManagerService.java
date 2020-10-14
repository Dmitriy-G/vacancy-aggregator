package com.demo.aggregator.service;

import com.demo.aggregator.config.sources.Source;

/**
 * Interface for managing monitors
 *
 * @author Dmitriy G
 */
public interface MonitorManagerService {

    /**
     * Method for starting work with monitors
     */
    void process();

    /**
     * Method for start monitor
     *
     * @param monitorService
     *        Type of monitor
     * @param source
     *        Source of monitor
     */
    void startMonitor(MonitorService monitorService);

    /**
     * Method for stop monitor
     *
     * @param monitorService
     *        Type of monitor
     * @param source
     *        Source of monitor
     */
    void stopMonitor(MonitorService monitorService);
}
