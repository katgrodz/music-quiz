package pl.gitsolutions.projects.samples.simplequiz.backend.service;

import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Task;

import java.util.List;

/**
 * Created by katgr on 30.12.2017.
 */
public interface TaskService {

    Task getTaskDetails(Long taskId);

    List<Task> getTasksInQuiz(Long quizId);

    List<Task> getAllTasks();

    Integer countTasksInQuiz(Long quizId);
}
