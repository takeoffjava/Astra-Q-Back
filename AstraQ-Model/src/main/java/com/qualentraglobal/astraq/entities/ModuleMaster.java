package com.qualentraglobal.astraq.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Module_Master")
public class ModuleMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Master_ID")
    private Long masterId;

    @Column(name = "Module_Name", nullable = false, length = 1)
    private String moduleName;

    @Column(name = "Created_On")
    private LocalDate createdOn;

    @Column(name = "Updated_On")
    private LocalDate updatedOn;

    @Column(name = "Is_Active")
    private Boolean isActive;

    @Column(name = "Description", length = 255)
    private String description;

    // Foreign key to Client_Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_ID", nullable = false)
    private Client client;
}

