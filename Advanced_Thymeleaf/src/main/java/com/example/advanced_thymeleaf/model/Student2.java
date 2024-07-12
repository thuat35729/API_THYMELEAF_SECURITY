package com.example.advanced_thymeleaf.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    @NotBlank(message = "Không được để trống")
    @Email(message = "không đungs đinhj danh email")
    String email;
    @NotBlank(message = "Không được để trống")
    String fullname;
    @NotNull(message = "Không để trống điểm")
    @PositiveOrZero(message = "Điểm phải lớn hơn 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
    Double marks;
    @NotNull(message = "Chọn giới tính")
    Boolean gender;
    @NotBlank(message = "Chọn quốc tịch")
    String country;
}
