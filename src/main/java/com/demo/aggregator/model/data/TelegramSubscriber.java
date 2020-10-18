package com.demo.aggregator.model.data;

import com.demo.aggregator.model.core.Subscriber;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;


/**
 * Data model for telegram subscriber
 */
@Document(collection = "subscribers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class TelegramSubscriber implements Subscriber {
    /**
     * The telegram chat id with subscriber
     */
    @Id
    private String chatId;
    /**
     * The map of sent vacancies
     * key The vacancy id
     * value The source id (like rabota.ua)
     */
    private Map<String, String> sentVacancy;
}
