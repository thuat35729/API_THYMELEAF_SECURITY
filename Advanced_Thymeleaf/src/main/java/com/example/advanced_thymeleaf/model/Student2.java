package com.example.advanced_thymeleaf.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    @NotBlank(message = "{message.email}")
    @Email(message = "không đúng danh danh email")
    String email;
    @NotBlank(message = "{message.name}")
    String fullname;
    @NotNull(message = "{message.marks}")
    @PositiveOrZero(message = "Điểm phải lớn hơn 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
    Double marks;
    @NotNull(message = "{message.gender}")
    Boolean gender;
    @NotBlank(message = "{message.nationality}")
    String country;
}
