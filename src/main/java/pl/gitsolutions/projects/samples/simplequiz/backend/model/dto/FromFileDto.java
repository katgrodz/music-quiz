package pl.gitsolutions.projects.samples.simplequiz.backend.model.dto;

import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Quiz;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Task;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;

import java.util.List;

/**
 * Created by katgr on 30.12.2017.
 */
public class FromFileDto {

    List<Quiz> quizList;
    List<Task> taskList;
    List<Track> trackList;

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }
}
