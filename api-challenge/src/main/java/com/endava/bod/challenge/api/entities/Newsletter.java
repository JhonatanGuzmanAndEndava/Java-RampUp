package com.endava.bod.challenge.api.entities;

import java.util.ArrayList;
import java.util.List;

public class Newsletter {

    private String recipient;
    private List<Notification> notifications = new ArrayList<>();

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
