package com.myschool.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Enrollment {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnrollment;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, foreignKey =  @ForeignKey(name = "FK_Enrollment_Student"))
    private Student student;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private boolean state;

    @OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //fetch = FetchType.EAGER
    private List<EnrollmentDetail> details;

}
