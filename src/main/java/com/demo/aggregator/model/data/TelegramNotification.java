package com.demo.aggregator.model.data;

import com.demo.aggregator.model.core.Notification;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TelegramNotification implements Notification {
    private String chatId;
    private String messageText;
}
