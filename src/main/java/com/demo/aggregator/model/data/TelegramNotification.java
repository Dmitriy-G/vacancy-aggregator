package com.demo.aggregator.model.data;

import com.demo.aggregator.model.core.Notification;
import org.telegram.telegrambots.meta.api.objects.Message;

public class TelegramNotification implements Notification {

    private Message message;
}
