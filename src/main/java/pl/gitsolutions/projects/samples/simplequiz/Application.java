package pl.gitsolutions.projects.samples.simplequiz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TrackRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.AnswerGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.TrackGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.integration.UserGateway;
import pl.gitsolutions.projects.samples.simplequiz.backend.model.jpa.Track;
import pl.gitsolutions.projects.samples.simplequiz.backend.util.ReadFromFile;

import java.util.List;

/**
 * Created by katgr on 12.11.2017.
 */
@SpringBootApplication
public class Application {

    List<Track> trackList;
    String fileName = "C:\\Development\\projects\\simplequiz\\datafile.txt";
//    String fileName = "classpath:datafile.txt";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(final TrackRepository trackRepo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                trackList = ReadFromFile.loadToDatabase(fileName);
                trackRepo.save(trackList);
            }
        };
    }
}
