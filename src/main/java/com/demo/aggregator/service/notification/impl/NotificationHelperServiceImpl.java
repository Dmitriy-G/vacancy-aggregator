package com.demo.aggregator.service.notification.impl;

import com.demo.aggregator.model.core.Notification;
import com.demo.aggregator.model.core.Vacancy;
import com.demo.aggregator.model.data.TelegramNotification;
import com.demo.aggregator.service.notification.NotificationHelperService;
import com.demo.aggregator.service.notification.NotificationSenderService;
import com.demo.aggregator.service.storage.NotificationStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationHelperServiceImpl implements NotificationHelperService {

    private NotificationStorageService storageService;
    //TODO: it's must be list of notification services (telegram, viber etc)
    private NotificationSenderService senderService;

    @Autowired
    public NotificationHelperServiceImpl(NotificationStorageService storageService, NotificationSenderService senderService) {
        this.storageService = storageService;
        this.senderService = senderService;
    }

    @Override
    public List<Notification> generateNotifications(Vacancy vacancy) {
        List<String> subscribersIds = storageService.getSubscribersChatIdList();
        List<Notification> notifications = new ArrayList<>();
        String notificationText = generateNotificationText(vacancy);
        for (String subscriberId: subscribersIds) {
            Notification notification = new TelegramNotification(subscriberId, notificationText);
            notifications.add(notification);
        }
        return notifications;
    }

    @Override
    public void sendVacancyToSubscribers(Vacancy vacancy) {
        List<Notification> notifications = generateNotifications(vacancy);
        for (Notification notification: notifications) {
            senderService.send(notification);
        }
    }

    private String generateNotificationText(Vacancy vacancy) {
        StringBuilder builder = new StringBuilder();
        builder.append(vacancy.getDesignBannerUrl()).append("\n")
                .append("Компания: ")
                .append(vacancy.getCompanyName()).append("\n")
                .append("Позиция: ")
                .append(vacancy.getName()).append("\n")
                .append("Город: ")
                .append(vacancy.getCityName()).append("\n")
                .append("Краткое описание: ")
                .append(vacancy.getShortDescription()).append("\n")
                .append("Дата размещения: ").append(vacancy.getDate()).append("\n\n");
        return builder.toString();
    }
}
