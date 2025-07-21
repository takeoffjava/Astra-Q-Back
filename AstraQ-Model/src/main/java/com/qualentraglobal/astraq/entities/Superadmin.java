package com.qualentraglobal.astraq.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "super_admin")
public class Superadmin {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "superadmin_id")
	    private Long superAdminId;

	    @Column(name = "user_firstname", length = 255)
	    private String userFirstname;

	    @Column(name = "user_lastname", length = 255)
	    private String userLastname;

	    @Column(name = "gender", length = 1)
	    private String gender;

	    @Column(name = "password", length = 255)
	    private String password;

	    @Column(name = "mobilenumber", length = 15)
	    private String mobileNumber;

	    @Column(name = "emailId", length = 255)
	    private String emailId;

	    @Column(name = "company_name", length = 255)
	    private String companyName;

	    @Column(name = "created_on")
	    private LocalDate createdOn;

	    @Column(name = "updated_on")
	    private LocalDate updatedOn;

	    @Column(name = "is_active")
	    private Boolean isActive;

	    @Column(name = "password_expired_On")
	    private LocalDate passwordExpiredOn;

	    @Column(name = "password_hint", length = 255)
	    private String passwordHint;

	    @Column(name = "security_question_1", length = 255)
	    private String securityQuestion1;

	    @Column(name = "security_answer_1", length = 255)
	    private String securityAnswer1;

	    @Column(name = "security_question_2", length = 255)
	    private String securityQuestion2;

	    @Column(name = "security_answer_2", length = 255)
	    private String securityAnswer2;

}
