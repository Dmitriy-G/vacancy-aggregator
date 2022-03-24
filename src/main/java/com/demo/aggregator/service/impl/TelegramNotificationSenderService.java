package com.demo.aggregator.service.impl;

import com.demo.aggregator.dto.Notification;
import com.demo.aggregator.sender.TelegramBot;
import com.demo.aggregator.service.NotificationSenderService;
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
