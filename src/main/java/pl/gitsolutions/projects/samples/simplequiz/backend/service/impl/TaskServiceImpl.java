package pl.gitsolutions.projects.samples.simplequiz.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.CreateTaskExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadTaskExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Task;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.TaskService;

import java.util.List;

/**
 * Created by katgr on 30.12.2017.
 */

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    ReadTaskExecutor readTaskExecutor;

    @Autowired
    CreateTaskExecutor createTaskExecutor;

    @Override
    public Task getTaskDetails(Long taskId) {
        return readTaskExecutor.getTaskDetails(taskId);
    }

    @Override
    public List<Task> getTasksInQuiz(Long quizId) {
        return readTaskExecutor.getTasksInQuiz(quizId);
    }

    @Override
    public List<Task> getAllTasks() {
        return readTaskExecutor.getAllTasks();
    }

    @Override
    public Integer countTasksInQuiz(Long quizId) {
        return readTaskExecutor.countTasksInQuiz(quizId);
    }
}
