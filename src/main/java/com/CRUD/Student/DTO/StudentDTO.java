package com.CRUD.Student.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private String name;
    @NotBlank
    //@Size(min = 1,max = 10,message = "Please enter a Number between length of 1 and 10")
    private String mobileNumber;
    private String department;
}
