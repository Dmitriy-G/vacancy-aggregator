package com.demo.aggregator.service;

import com.demo.aggregator.dto.Vacancy;

import java.util.List;
import java.util.Set;

/**
 * Base interface for work with storage
 */
public interface NotificationStorageService {
    /**
     * The method return all subscribers ids
     * @return all subscribers list of id
     */
    List<String> getSubscribersIdList();

    /**
     * The method add user to subscribers
     * @param subscriberId the id of new subscriber (like chatId or channelId)
     */
    void addIdToSubscribersList(String subscriberId, String keyWord);

    /**
     * The method remove user from subscribers
     * @param subscriberId the id of subscriber (like chatId or channelId)
     */
    void removeFromSubscribersList(String subscriberId);

    /**
     * The method add received vacancy to list (for ignoring duplicate)
     * @param subscriberId the id of subscriber (like chatId or channelId)
     * @param vacancy added vacancy
     */
    void addReceivedVacancyToSubscriberList(String subscriberId, Vacancy vacancy);

    /**
     * The method add received vacancy to list (for ignoring duplicate)
     * @param subscriberId the id of subscriber (like chatId or channelId)
     * @return all sent vacancy ids for subscriber id
     */
    Set<String> findVacanciesIdsBySubscriberId(String subscriberId);
}
