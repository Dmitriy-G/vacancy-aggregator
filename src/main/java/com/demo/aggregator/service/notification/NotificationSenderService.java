package com.demo.aggregator.service.notification;

import com.demo.aggregator.model.core.Notification;

/**
 * Interface for sand notifications
 *
 * @author Dmitriy G
 */
public interface NotificationSenderService {

    /**
     * Method for send notification
     *
     * @param notification notification for send
     *
     * @return true if success otherwise false
     */
    Boolean send(Notification notification);
}
