package com.CRUD.Student.DTO;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoursesDTO {
    private UUID id;
    private String name;
    private String author;
}
