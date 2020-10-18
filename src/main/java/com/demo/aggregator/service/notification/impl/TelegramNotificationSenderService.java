package com.demo.aggregator.service.notification.impl;

import com.demo.aggregator.config.TelegramBot;
import com.demo.aggregator.model.core.Notification;
import com.demo.aggregator.service.notification.NotificationSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramNotificationSenderService implements NotificationSenderService {

    private TelegramBot telegramBot;

    @Autowired
    public TelegramNotificationSenderService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @Override
    public Boolean send(Notification notification) {
        String chatId = notification.getChatId();
        String messageText = notification.getMessageText();
        telegramBot.sendMsg(chatId, messageText);
        return true;
    }
}
