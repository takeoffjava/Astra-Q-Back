package com.qualentraglobal.astraq.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "AstraQ_Version")
public class AstraQVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AstraQ_ID")
    private Long astraQId;

    @Column(name = "AstraQ_Name", nullable = false, length = 25)
    private String astraQName;

    @Column(name = "Created_On")
    private LocalDate createdOn;

    @Column(name = "Updated_On")
    private LocalDate updatedOn;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Description", length = 255)
    private String description;

    @Column(name = "Is_Active")
    private Boolean isActive;
}

