package com.demo.aggregator.service.storage;

import java.util.List;

public interface NotificationStorageService {
    List<String> getSubscribersChatIdList();
    void addIdToSubscribersList(String chatId);
    void removeFromSubscribersList(String chatId);
}
