package com.qualentraglobal.astraq.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "User_Role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Role")
    private Long userRoleId;

    @Column(name = "Role_Name", nullable = false, length = 100)
    private String roleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_ID", nullable = false)
    private Client client;

    @Column(name = "Created_On")
    private LocalDate createdOn;

    @Column(name = "Updated_On")
    private LocalDate updatedOn;

    @Column(name = "Is_Active")
    private Boolean isActive;
}
