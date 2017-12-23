package pl.gitsolutions.projects.samples.simplequiz.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Task;

import java.util.List;

/**
 * Created by katgr on 23.12.2017.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    Task getTaskById(Long taskId);

    List<Task> getTasksByQuizId(Long quizId);

}
