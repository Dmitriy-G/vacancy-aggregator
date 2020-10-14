package com.demo.aggregator.config.sources;

/**
 * Main data source interface.
 * All data source classes must implement this interface.
 *
 * @author Dmitriy G
 */
public interface Source {
    /**
     * @return url of data source
     */
    String getUrl();
}
