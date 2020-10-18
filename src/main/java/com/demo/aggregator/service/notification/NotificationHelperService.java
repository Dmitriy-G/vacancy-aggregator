package com.demo.aggregator.service.notification;

import com.demo.aggregator.model.core.Notification;
import com.demo.aggregator.model.core.Vacancy;

import java.util.List;

public interface NotificationHelperService {
    List<Notification> generateNotifications(Vacancy vacancy);
    void sendVacancyToSubscribers(Vacancy vacancy);
    void addReceivedVacancyToSubscriberList(String chatId, Vacancy vacancy);
}
