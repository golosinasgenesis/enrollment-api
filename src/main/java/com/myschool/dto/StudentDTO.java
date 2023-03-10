package com.myschool.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //lo retira del response
public class StudentDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String nameStudent;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String lastnameStudent;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 8)
    private String dniStudent;

    @NotNull
    @Min(value = 1)
    private short ageStudent;

}
