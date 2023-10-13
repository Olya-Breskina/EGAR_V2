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
    @SequenceGenerator(name = "AccountingGenerator", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountingGenerator")
    @Column(name = "accounting_id", nullable = false)
    private Long accountingID;

    @Schema(description = "work_days")
    private long workDays;
    @Schema(description = "salary_of_work_days")
    private BigDecimal salaryOfWorkDays;
    @Schema(description = "days_of_Vacation")
    private long daysOfVacation;
    @Schema(description = "salary_of_work_days")
    private BigDecimal salaryOfVacation;
    @Schema(description = "days_of_day_off")
    private long daysOfDayOff;
    @Schema(description = "salary_of_day_off")
    private BigDecimal salaryOfDayOff;
    @Schema(description = "days_of_sick_day")
    private long daysOfSickDay;
    @Schema(description = "salary_of_sick_day")
    private BigDecimal salaryOfSickDay;
    @Schema(description = "salary_gross")
    private BigDecimal salaryGROSS;
    private BigDecimal tax;
    @Schema(description = "salary_on_handy")
    private BigDecimal salaryOnHandy;
}
