package com.qualentraglobal.astraq.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Client_ID")
    private Long clientId;

    @Column(name = "Client_Name", length = 255, nullable = false)
    private String clientName;

    @Column(name = "Created_On")
    private LocalDate createdOn;

    @Column(name = "Updated_On")
    private LocalDate updatedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AstraQ_ID", nullable = false)
    private AstraQVersion astraQVersion;

    @Column(name = "IsTrailversion")
    private Boolean isTrailVersion;

    @Column(name = "Trailversion_Expired_On")
    private LocalDate trailVersionExpiredOn;

    @Column(name = "Is_Active")
    private Boolean isActive;

    @Column(name = "Price")
    private Double price;

    @Column(name = "AstraQ_Expired_On")
    private LocalDate astraQExpiredOn;

    @Column(name = "Logo_Name", length = 255)
    private String logoName;

    @Column(name = "Logo_Path", length = 255)
    private String logoPath;
}

