package pl.gitsolutions.projects.samples.simplequiz.backend.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TaskRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Task;

import java.util.List;

/**
 * Created by katgr on 19.11.2017.
 */
@Component
public class ReadTaskExecutor{

    @Autowired
    TaskRepository taskRepository;

    public Task getTaskDetails(Long taskId){
        return taskRepository.getTaskById(taskId);
    }

    public List<Task> getTasksInQuiz(Long quizId){
        return taskRepository.getTasksByQuizId(quizId);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Integer countTasksInQuiz(Long quizId) {
        return taskRepository.countTaskByQuizId(quizId);
    }

}
