package com.qualentraglobal.astraq.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    private Long userId;

    @Column(name = "User_Firstname", length = 255, nullable = false)
    private String userFirstname;

    @Column(name = "User_Lastname", length = 255, nullable = false)
    private String userLastname;

    @Column(name = "Gender", length = 10, nullable = false)
    private String gender;

    @Column(name = "Password", length = 255, nullable = false)
    private String password;

    @Column(name = "Mobilenumber", length = 20,nullable = false)
    private String mobilenumber;

    @Column(name = "EmailId", length = 100,nullable = false)
    private String emailId;

    @Column(name = "\"Company Name\"", length = 255)
    private String companyName;

    @Column(name = "Created_On")
    private LocalDate createdOn;

    @Column(name = "Updated_On")
    private LocalDate updatedOn;

    @Column(name = "Is_Active")
    private Boolean isActive;

    // Foreign key to User_Role table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Role", nullable = false)
    private UserRole userRole;

    // Foreign key to Client_Table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_ID", nullable = false)
    private Client client;

    @Column(name = "Password_Exipired_On")
    private LocalDate passwordExpiredOn;

    @Column(name = "Password_Hint", length = 255)
    private String passwordHint;

    @Column(name = "Security_Quesion-1", length = 255)
    private String securityQuestion1;

    @Column(name = "Security_Answer-1", length = 255)
    private String securityAnswer1;

    @Column(name = "Security_Quesion-2", length = 255)
    private String securityQuestion2;

    @Column(name = "Security_Answer-2", length = 255)
    private String securityAnswer2;
}

