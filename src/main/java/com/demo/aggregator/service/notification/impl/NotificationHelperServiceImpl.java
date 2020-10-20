package com.demo.aggregator.service.notification.impl;

import com.demo.aggregator.model.core.Notification;
import com.demo.aggregator.model.core.Vacancy;
import com.demo.aggregator.model.data.TelegramNotification;
import com.demo.aggregator.service.notification.NotificationHelperService;
import com.demo.aggregator.service.notification.NotificationSenderService;
import com.demo.aggregator.service.storage.NotificationStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class NotificationHelperServiceImpl implements NotificationHelperService {

    private NotificationStorageService storageService;
    //TODO: it's must be list of notification services (telegram, viber etc)
    private NotificationSenderService senderService;

    private final String RABOTA_UA_URL = "https://rabota.ua/company1/vacancy";

    @Autowired
    public NotificationHelperServiceImpl(NotificationStorageService storageService, NotificationSenderService senderService) {
        this.storageService = storageService;
        this.senderService = senderService;
    }

    @Override
    public List<Notification> generateNotifications(Vacancy vacancy) {
        List<String> subscribersIds = storageService.getSubscribersIdList();
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
            String subscriberId = notification.getChatId();
            Set<String> sentVacanciesId = storageService.findVacanciesIdsBySubscriberId(subscriberId);
            if (!sentVacanciesId.contains(vacancy.getId())) {
                Boolean result = senderService.send(notification);
                if (result) {
                    addReceivedVacancyToSubscriberList(subscriberId, vacancy);
                }
            } else {
                log.info("Vacancy with id " + vacancy.getId() + " already sent to subscriber " + subscriberId);
            }
        }
    }

    @Override
    public void addReceivedVacancyToSubscriberList(String chatId, Vacancy vacancy) {
        storageService.addReceivedVacancyToSubscriberList(chatId, vacancy);
    }

    private String generateNotificationText(Vacancy vacancy) {
        StringBuilder builder = new StringBuilder();
        builder.append("[.](").append(vacancy.getDesignBannerUrl()).append(")")
                .append("\n")
                .append("*Компания: ")
                .append(vacancy.getCompanyName()).append("*\n")
                .append("*Позиция:* ")
                .append(vacancy.getName()).append("\n")
                .append("*Город:* ")
                .append(vacancy.getCityName()).append("\n")
                .append("*Краткое описание:* ")
                .append(vacancy.getShortDescription()).append("\n")
                .append("*Дата размещения:* ").append(vacancy.getDate()).append("\n\n")
                .append("*Ссылка на вакансию:* ").append(RABOTA_UA_URL).append(vacancy.getId()).append("\n\n");
        return builder.toString();
    }
}
