package pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by katgr on 19.11.2017.
 */
@Table(name = "QUIZ")
@Entity(name = "Quiz")
@NoArgsConstructor
@AllArgsConstructor
public class Quiz extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "QUIZ_ID", nullable = false)
    private Long id;

    @Column(name = "QUIZ_DESCRIPTION")
    private String quizDescription;
}
