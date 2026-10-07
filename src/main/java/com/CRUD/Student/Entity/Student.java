package com.CRUD.Student.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 100, nullable = false,updatable = false)
    private UUID id;

    @NotNull
    private String name;
    @Size(max = 10)
    private String mobileNumber;
    private String department;

    @Version
    private Integer version;
}
