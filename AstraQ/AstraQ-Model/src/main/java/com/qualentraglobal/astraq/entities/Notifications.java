package com.qualentraglobal.astraq.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Notifications")
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Notification_ID")
    private Long notificationId;

    @Column(name = "Notification", length = 255, nullable = false)
    private String notification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID", nullable = false)
    private Users users;

    @Column(name = "Created_On")
    private LocalDate createdOn;

    @Column(name = "Expired")
    private Boolean expired;
}

