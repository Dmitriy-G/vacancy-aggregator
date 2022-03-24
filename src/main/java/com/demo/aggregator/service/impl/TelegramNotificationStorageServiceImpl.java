package com.demo.aggregator.service.impl;

import com.demo.aggregator.entity.Subscriber;
import com.demo.aggregator.dto.Vacancy;
import com.demo.aggregator.repository.TelegramSubscriberRepository;
import com.demo.aggregator.service.NotificationStorageService;
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
        List<Subscriber> subscribers = telegramSubscriberRepository.findAll();
        return subscribers.stream().map(Subscriber::getChatId).collect(Collectors.toList());
    }

    @Override
    public void addIdToSubscribersList(String subscriberId, String keyWord ) {
        Subscriber subscriber = new Subscriber(subscriberId, keyWord, new HashMap<>());
        telegramSubscriberRepository.save(subscriber);
    }

    @Override
    public void removeFromSubscribersList(String chatId) {
        telegramSubscriberRepository.deleteByChatId(chatId);
    }

    @Override
    public void addReceivedVacancyToSubscriberList(String chatId, Vacancy vacancy) {
        Subscriber subscriber = telegramSubscriberRepository.findByChatId(chatId);
        Map<String, String> sentVacancyMap = subscriber.getSentVacancy();
        sentVacancyMap.put(vacancy.getId(), "rabotaUa");
        subscriber.setSentVacancy(sentVacancyMap);
        telegramSubscriberRepository.save(subscriber);
    }

    @Override
    public Set<String> findVacanciesIdsBySubscriberId(String subscriberId) {
        Subscriber subscriber = telegramSubscriberRepository.findByChatId(subscriberId);
        return subscriber.getSentVacancy().keySet();
    }
}
