package pl.gitsolutions.projects.samples.simplequiz.backend.integration;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Task;

import java.util.List;

/**
 * Created by katgr on 30.12.2017.
 */
@RequestMapping(value = "/tasks")
public interface TaskGateway {

    @RequestMapping(value = "/task-details/{taskId}", method = RequestMethod.GET)
    Task getTaskDetails(@PathVariable Long taskId);

    @RequestMapping(value = "/tasks-in-quiz/{quizId}", method = RequestMethod.GET)
    List<Task> getTasksInQuiz(@PathVariable Long quizId);

    @RequestMapping(value = "/all-taska", method = RequestMethod.GET)
    List<Task> getAllTasks();

    @RequestMapping(value = "/count-in-quiz/{quizId}", method = RequestMethod.GET)
    Integer countTasksInQuiz(@PathVariable Long quizId);

}
