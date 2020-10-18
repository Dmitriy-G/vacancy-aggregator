package com.demo.aggregator.model.core;

import java.util.Date;

/**
 * Main vacancy data interface.
 * The interface includes basic methods for working with data model.
 * All vacancies data classes must implement this interface.
 *
 * @author Dmitriy G
 */
public interface Vacancy {
    /**
     * Set id for vacancy
     *
     * @param id The id of the vacancy
     */
    void setId(String id);

    /**
     * Set name for vacancy
     *
     * @param name The name of the vacancy
     */
    void setName(String name);

    /**
     * Set date for vacancy
     *
     * @param date The date of the vacancy
     */
    void setDate(Date date);

    /**
     * Set city name for vacancy
     *
     * @param cityName The city name of the vacancy
     */
    void setCityName(String cityName);

    /**
     * Set company name for vacancy
     *
     * @param companyName The company name of the vacancy
     */
    void setCompanyName(String companyName);

    /**
     * Set short description for vacancy
     *
     * @param shortDescription The short description of the vacancy
     */
    void setShortDescription(String shortDescription);

    /**
     * Set company logo for vacancy
     *
     * @param designBannerUrl The company logo of the vacancy
     */
    void setDesignBannerUrl(String designBannerUrl);

    /**
     * Get id for vacancy
     */
    String getId();

    /**
     * Get name for vacancy
     */
    String getName();

    /**
     * Get date for vacancy
     */
    Date getDate();

    /**
     * Get city name for vacancy
     */
    String getCityName();

    /**
     * Get company name for vacancy
     */
    String getCompanyName();

    /**
     * Get short description for vacancy
     */
    String getShortDescription();

    /**
     * Get company logo url for vacancy
     */
    String getDesignBannerUrl();

}
