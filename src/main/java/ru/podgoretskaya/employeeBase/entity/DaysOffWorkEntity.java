package ru.podgoretskaya.employeeBase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "days_off_work")
public class DaysOffWorkEntity {
    @Id
    @SequenceGenerator(name = "DaysOffWorkGenerator", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DaysOffWorkGenerator")
    @Column(name = "days_off_work_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @JsonIgnore
    @ToString.Exclude
    private PersonEntity person;


    private LocalDate start;
    private LocalDate finish;
    @Schema(description = "absence_reason")
    private String absenceReason;

}
