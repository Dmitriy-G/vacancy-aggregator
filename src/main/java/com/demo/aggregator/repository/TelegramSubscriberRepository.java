package com.demo.aggregator.repository;

import com.demo.aggregator.model.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramSubscriberRepository extends MongoRepository<Subscriber, String> {
    Subscriber deleteByChatId(String chatId);
    Subscriber findByChatId(String chatId);
}
