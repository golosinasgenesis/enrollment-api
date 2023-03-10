package com.myschool.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //lo retira del response
public class EnrollmentDTO {

    private Long idEnrollment;

    @NotNull
    @JsonIncludeProperties(value = {"id", "nameStudent"})
    private StudentDTO student;

    @NotNull
    private LocalDateTime datetime;

    @NotNull
    private boolean state;

    @Valid
    @NotNull
    @NotEmpty
    @JsonManagedReference
    private List<EnrollmentDetailDTO> details;

}
