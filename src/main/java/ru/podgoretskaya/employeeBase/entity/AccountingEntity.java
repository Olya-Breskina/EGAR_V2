package ru.podgoretskaya.employeeBase.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounting")
public class AccountingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accounting_id", nullable = false)
    private Long accountingID;

    @Column(name = "work_days")
    private long workDays;
    @Column(name = "salary_of_work_days")
    private BigDecimal salaryOfWorkDays;
    @Column(name = "days_of_vacation")
    private long daysOfVacation;
    @Column(name = "salary_of_vacation")
    private BigDecimal salaryOfVacation;
    @Column(name = "days_of_day_off")
    private long daysOfDayOff;
    @Column(name = "salary_of_day_off")
    private BigDecimal salaryOfDayOff;
    @Column(name = "days_of_sick_day")
    private long daysOfSickDay;
    @Column(name = "salary_of_sick_day")
    private BigDecimal salaryOfSickDay;
    @Column(name = "salary_gross")
    private BigDecimal salaryGROSS;
    private BigDecimal tax;
    @Column(name = "salary_on_handy")
    private BigDecimal salaryOnHandy;
}
