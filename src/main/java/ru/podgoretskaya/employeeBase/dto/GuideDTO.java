package ru.podgoretskaya.employeeBase.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.podgoretskaya.employeeBase.dto.enums.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "данные о сотрудниках в общедоступном справочнике")
public class GuideDTO {
    @Schema(description = "ID сотрудника")
    private long id;
    @Schema(description = "фамилия")
    private String lastName;
    @Schema(description = "имя")
    private String firstName;
    @Schema(description = "дата рождения")
    private LocalDate birthdate;
    @Schema(description = "должность")
    private PositionEnum position;
    @Schema(description = "отдел")
    private DepartmentEnum department;
    @Schema(description = "категория")
    private GradeEnum grade;
    @Schema(description = "номер телефона")
    private String phoneNumber;
    @Schema(description = "электронный адрес")
    private String email;
    @Schema(description = "занятость (место работы)")
    private OccupancyEnum occupancy;
    @Schema(description = "режим работы")
    private WorkingModeEnum workingMode;
}