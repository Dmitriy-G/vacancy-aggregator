package com.demo.aggregator.repository;

import com.demo.aggregator.model.data.TelegramSubscriber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramSubscriberRepository extends MongoRepository<TelegramSubscriber, String> {
    TelegramSubscriber deleteByChatId(String chatId);
    TelegramSubscriber findByChatId(String chatId);
}
