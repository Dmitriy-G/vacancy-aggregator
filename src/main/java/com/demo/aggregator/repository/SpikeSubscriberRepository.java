package com.demo.aggregator.repository;

import com.demo.aggregator.model.Subscriber;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Mock repository for running without mongo
@Repository
public class SpikeSubscriberRepository {

    private Map<String, Subscriber> subscribers = new HashMap<>();

    public void save(Subscriber subscriber) {
        subscribers.put(subscriber.getChatId(), subscriber);
    }

    public List<Subscriber> findAll() {
        return new ArrayList<>(subscribers.values());
    }

    public void deleteByChatId(String chatId) {
        subscribers.remove(chatId);
    }

    public Subscriber findByChatId(String chatId) {
        return subscribers.get(chatId);
    }
}
