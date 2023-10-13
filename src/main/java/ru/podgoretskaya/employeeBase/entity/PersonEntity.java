package ru.podgoretskaya.employeeBase.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.podgoretskaya.employeeBase.dto.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class PersonEntity {
    @Id
    @SequenceGenerator(name = "PersonGenerator", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PersonGenerator")
    @Column(name = "Person_id", nullable = false)
    private Long personID;

    @OneToOne
    @JoinColumn(name = "accounting_id")
    private AccountingEntity accountingEntity;

    @OneToOne
    @JoinColumn(name = "employee_card_id")
    private DaysOffWorkEntity daysOffWorkEntity;

    private String lastName;

    private String firstName;

    private String middleName;

    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    private PositionEnum position;

    @Enumerated(EnumType.STRING)
    private DepartmentEnum department;

    @Enumerated(EnumType.STRING)
    private GradeEnum grade;

    @Schema(description = "номер телефона")
    private String phoneNumber;

    private String email;

    @Enumerated(EnumType.STRING)
    private OccupancyEnum occupancy;

    @Enumerated(EnumType.STRING)
    @Column(name = "working_mode")
    private WorkingModeEnum workingMode;

    @Column(name = "work_experience_Current")
    private Double workExperienceCurrent;

    private BigDecimal salary;
}
