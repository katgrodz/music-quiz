package pl.gitsolutions.projects.samples.simplequiz.backend.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.TaskGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Task;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.TaskService;

import java.util.List;

/**
 * Created by katgr on 30.12.2017.
 */
@RestController
@RequestMapping(value = "/tasks")
public class TaskGatewayController implements TaskGateway {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/task-details/{taskId}", method = RequestMethod.GET)
    @Override
    public Task getTaskDetails(@PathVariable Long taskId) {
        return taskService.getTaskDetails(taskId);
    }

    @RequestMapping(value = "/tasks-in-quiz/{quizId}", method = RequestMethod.GET)
    @Override
    public List<Task> getTasksInQuiz(@PathVariable Long quizId) {
        return taskService.getTasksInQuiz(quizId);
    }

    @RequestMapping(value = "/all-taska", method = RequestMethod.GET)
    @Override
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @RequestMapping(value = "/count-in-quiz/{quizId}", method = RequestMethod.GET)
    @Override
    public Integer countTasksInQuiz(@PathVariable Long quizId) {
        return taskService.countTasksInQuiz(quizId);
    }
}
