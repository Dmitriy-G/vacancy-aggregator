package com.demo.aggregator.service.storage.impl;

import com.demo.aggregator.service.storage.NotificationStorageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationStorageServiceImpl implements NotificationStorageService {

    //TODO: needed implement it's via db or in memory storage
    private List<String> subscribers = new ArrayList<>();

    @Override
    public List<String> getSubscribersChatIdList() {
        return subscribers;
    }

    @Override
    public void addIdToSubscribersList(String chatId) {
         subscribers.add(chatId);
    }

    @Override
    public void removeFromSubscribersList(String chatId) {
        subscribers.remove(chatId);
    }
}
