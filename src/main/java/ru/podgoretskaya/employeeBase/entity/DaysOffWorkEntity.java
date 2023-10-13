package ru.podgoretskaya.employeeBase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_card")
public class DaysOffWorkEntity {
    @Id
    @SequenceGenerator(name = "EmployeeCardGenerator", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmployeeCardGenerator")
    @Column(name = "employee_card_id", nullable = false)
    private Long employeeCardID;

    private LocalDate dayOff;

    private LocalDate vacation_start;
    private LocalDate vacation_end;

    private LocalDate sick_days_start;
    private LocalDate sick_days_end;
}
