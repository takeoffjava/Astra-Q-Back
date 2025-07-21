package com.qualentraglobal.astraq.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Quiz_Master")
public class QuizMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Quiz_ID")
    private Long quizId;

    @Column(name = "Quiz_Name", nullable = false, length = 1)
    private String quizName;

    @Column(name = "Created_On")
    private LocalDate createdOn;

    @Column(name = "Updated_On")
    private LocalDate updatedOn;

    @Column(name = "Is_Active")
    private Boolean isActive;

    @Column(name = "Description", length = 255)
    private String description;

    // Foreign key to Training_Master
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Training_ID", nullable = false)
    private TrainingMaster training;
}

