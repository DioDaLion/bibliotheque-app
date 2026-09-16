package com.bibliotheque.service;

import com.bibliotheque.model.Member;

public class NotificationService {

    public void notifyBookAvailable(Member member, String title) {
        System.out.printf("Notification envoyee a %s : le livre '%s' est disponible.%n",
                member.getEmail(), title);
    }
}
