package com.myschool.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //lo retira del response
public class CourseDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nameCourse;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 20)
    private String initialsCourse;

    @NotNull
    private boolean stateCourse;

}
