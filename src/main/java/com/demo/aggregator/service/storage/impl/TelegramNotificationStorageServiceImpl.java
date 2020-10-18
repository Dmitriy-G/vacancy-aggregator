package com.demo.aggregator.service.storage.impl;

import com.demo.aggregator.model.core.Vacancy;
import com.demo.aggregator.model.data.TelegramSubscriber;
import com.demo.aggregator.repository.TelegramSubscriberRepository;
import com.demo.aggregator.service.storage.NotificationStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TelegramNotificationStorageServiceImpl implements NotificationStorageService {

    private TelegramSubscriberRepository telegramSubscriberRepository;

    @Autowired
    public TelegramNotificationStorageServiceImpl(TelegramSubscriberRepository telegramSubscriberRepository) {
        this.telegramSubscriberRepository = telegramSubscriberRepository;
    }

    @Override
    public List<String> getSubscribersIdList() {
        List<TelegramSubscriber> subscribers = telegramSubscriberRepository.findAll();
        return subscribers.stream().map(TelegramSubscriber::getChatId).collect(Collectors.toList());
    }

    @Override
    public void addIdToSubscribersList(String subscriberId) {
        TelegramSubscriber subscriber = new TelegramSubscriber(subscriberId, new HashMap<>());
        telegramSubscriberRepository.save(subscriber);
    }

    @Override
    public void removeFromSubscribersList(String chatId) {
        telegramSubscriberRepository.deleteByChatId(chatId);
    }

    @Override
    public void addReceivedVacancyToSubscriberList(String chatId, Vacancy vacancy) {
        TelegramSubscriber subscriber = telegramSubscriberRepository.findByChatId(chatId);
        Map<String, String> sentVacancyMap = subscriber.getSentVacancy();
        sentVacancyMap.put(vacancy.getId(), "rabotaUa");
        subscriber.setSentVacancy(sentVacancyMap);
        telegramSubscriberRepository.save(subscriber);
    }

    @Override
    public Set<String> findVacanciesIdsBySubscriberId(String subscriberId) {
        TelegramSubscriber subscriber = telegramSubscriberRepository.findByChatId(subscriberId);
        return subscriber.getSentVacancy().keySet();
    }
}
