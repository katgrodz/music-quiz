package pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by katgr on 19.11.2017.
 */
@Table(name = "TASK")
@Entity(name = "Task")
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Task extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TASK_ID", nullable = false)
    private Long id;

    @Column(name = "TASK_DESCRIPTION")
    private String taskDescription;

    @Column(name = "QUIZ_ID")
    private Long quizId;
}
