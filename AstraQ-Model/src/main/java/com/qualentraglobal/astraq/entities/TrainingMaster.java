package com.qualentraglobal.astraq.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Training_Master")
public class TrainingMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Training_ID")
    private Long trainingId;

    @Column(name = "Training_Name", nullable = false, length = 1)
    private String trainingName;

    @Column(name = "Created_On")
    private LocalDate createdOn;

    @Column(name = "Updated_On")
    private LocalDate updatedOn;

    @Column(name = "Is_Active")
    private Boolean isActive;

    @Column(name = "Description", length = 255)
    private String description;

    @Column(name = "Training_Meterial_Path", length = 255)
    private String trainingMaterialPath;

    // Foreign key to Client_Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_ID", nullable = false)
    private Client client;
}

