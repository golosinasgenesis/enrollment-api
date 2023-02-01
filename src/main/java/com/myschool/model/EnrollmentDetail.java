package com.myschool.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class EnrollmentDetail {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnrollmentDetail;

    @ManyToOne
    @JoinColumn(name = "enrollment_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EnrollmentDetail_Enrollment"))
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, foreignKey = @ForeignKey(name = "FK_EnrollmentDetail_Course"))
    private Course course;

    @Column(length = 5, nullable = false)
    private String classroom;
}
