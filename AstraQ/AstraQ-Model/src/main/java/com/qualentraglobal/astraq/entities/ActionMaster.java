package com.qualentraglobal.astraq.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Action_Master")
public class ActionMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Action_ID")
    private Long actionId;

    @Column(name = "Action_Name", nullable = false, length = 1)
    private String actionName;

    @Column(name = "Created_On")
    private LocalDate createdOn;

    @Column(name = "Updated_On")
    private LocalDate updatedOn;

    @Column(name = "Is_Active")
    private Boolean isActive;

    @Column(name = "Description", length = 255)
    private String description;
}

