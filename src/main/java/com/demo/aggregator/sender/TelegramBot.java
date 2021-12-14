package com.demo.aggregator.sender;

import com.demo.aggregator.service.NotificationStorageService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PostConstruct;

/**
 * Bot for send notifications via telegram
 *
 * @author Dmitriy G
 */
@Component
public class TelegramBot extends TelegramLongPollingBot {

//    TODO: move to properties
    private String TELEGRAM_BOT_NAME = "";
    private String TELEGRAM_BOT_TOKEN = "";

    private NotificationStorageService notificationStorageService;

    @Autowired
    public TelegramBot(NotificationStorageService notificationStorageService) {
        this.notificationStorageService = notificationStorageService;
    }

    @PostConstruct
    private void postConstruct() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method for receive message from user
     *
     * @param update contains message from user
     */
    @Override
    public void onUpdateReceived(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String messageText = update.getMessage().getText();
        switch (messageText) {
            case "subscribe": {
                notificationStorageService.addIdToSubscribersList(chatId);
                String message = "You was added to subscribers";
                sendMsg(chatId, message);
                break;
            }
            case "stop": {
                notificationStorageService.removeFromSubscribersList(chatId);
                String message = "You was removed from subscribers";
                sendMsg(chatId, message);
                break;
            }
            default: {
                String message = "Unknown command: " + update.getMessage().getText();
                sendMsg(chatId, message);
            }
        }
    }

    /**
     * Method for get bot username
     *
     * @return the username
     */
    @Override
    public String getBotUsername() {
        return TELEGRAM_BOT_NAME;
    }

    /**
     * Method for get bot token
     *
     * @return the token
     */
    @Override
    public String getBotToken() {
        return TELEGRAM_BOT_TOKEN;
    }

    /**
     * Method for sending message to chat
     * @param chatId id of the chat
     * @param message the message for user
     */
    @SneakyThrows
    public void sendMsg(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        execute(sendMessage);
    }
}
