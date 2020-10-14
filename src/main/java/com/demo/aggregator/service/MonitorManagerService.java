package com.demo.aggregator.service;

/**
 * Interface for managing monitors
 *
 * @author Dmitriy G
 */
public interface MonitorManagerService {
    /**
     * Method for start monitor
     *
     * @param monitorService
     *        Type of monitor
     */
    void startMonitor(MonitorService monitorService);

    /**
     * Method for stop monitor
     *
     * @param monitorService
     *        Type of monitor
     */
    void stopMonitor(MonitorService monitorService);
}
