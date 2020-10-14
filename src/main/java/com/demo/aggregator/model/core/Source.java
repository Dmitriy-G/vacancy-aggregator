package com.demo.aggregator.model.core;

import java.net.URL;

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
    URL getUrl();
}
