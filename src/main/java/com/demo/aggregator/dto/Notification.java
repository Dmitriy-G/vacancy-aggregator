package com.demo.aggregator.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Notification {
    private String chatId;
    private String messageText;
}
