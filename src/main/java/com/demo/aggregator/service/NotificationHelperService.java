package com.demo.aggregator.service;

import com.demo.aggregator.dto.Notification;
import com.demo.aggregator.dto.Vacancy;

import java.util.List;

public interface NotificationHelperService {
    List<Notification> generateNotifications(Vacancy vacancy);
    void sendVacancyToSubscribers(Vacancy vacancy);
    void addReceivedVacancyToSubscriberList(String chatId, Vacancy vacancy);
}
