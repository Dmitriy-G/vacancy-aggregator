package com.demo.aggregator.service;


/**
 * Base monitor interface
 *
 * @author Dmitriy G
 */
public interface MonitorService {
    void monitoring();
    void monitoring(Long intervalSeconds);
    void stopMonitoring();
}
