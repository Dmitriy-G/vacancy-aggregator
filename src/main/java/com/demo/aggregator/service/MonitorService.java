package com.demo.aggregator.service;


import com.demo.aggregator.model.core.Source;

/**
 * Base monitor interface
 * @param <T> the type of entity for monitoring
 *
 * @author Dmitriy G
 */
public interface MonitorService<T extends Source> {
    void monitoring(T t);
    void monitoring(T t, Long intervalSeconds);
}
