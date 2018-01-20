package pl.gitsolutions.projects.samples.simplequiz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.QuizRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TaskRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TrackRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.AnswerGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.TrackGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.UserGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.dto.FromFileDto;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;
import pl.gitsolutions.projects.samples.simplequiz.backend.util.ReadFromFile;

import java.util.List;

/**
 * Created by katgr on 12.11.2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

    List<Track> trackList;
    String fileName = "C:\\Development\\projects\\simplequiz\\datafile20180101.txt";

//    String fileName = "classpath:datafile.txt";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(final TrackRepository trackRepo,final TaskRepository taskRepo, final QuizRepository quizRepo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                fromFileDto = ReadFromFile.loadToDatabase(fileName);
                quizRepo.save(fromFileDto.getQuizList());
                taskRepo.save(fromFileDto.getTaskList());
                trackRepo.save(fromFileDto.getTrackList());
            }
        };
    }
}
