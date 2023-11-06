package ru.podgoretskaya.employeeBase.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.podgoretskaya.employeeBase.dto.enums.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = false)
    private Long personID;

    @OneToOne
    @JoinColumn(name = "accounting_id")
    private AccountingEntity accountingEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    @JsonIgnore
    @ToString.Exclude
    private List<DaysOffWorkEntity> daysOffWorkEntity;

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

    private String phoneNumber;

    private String email;

    @Enumerated(EnumType.STRING)
    private OccupancyEnum occupancy;

    @Enumerated(EnumType.STRING)
    @Column(name = "working_mode")
    private WorkingModeEnum workingMode;

    @Column(name = "work_experience_current")
    private Double workExperienceCurrent;

    private BigDecimal salary;
}
