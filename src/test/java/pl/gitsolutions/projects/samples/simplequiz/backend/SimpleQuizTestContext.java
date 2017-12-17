package pl.gitsolutions.projects.samples.simplequiz.backend;

import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.AnswerRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.dao.TrackRepository;
import pl.gitsolutions.projects.samples.simplequiz.backend.executor.ReadAnswerExecutor;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.AnswerService;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.impl.AnswerServiceImpl;
import pl.gitsolutions.projects.samples.simplequiz.backend.service.impl.TrackServiceImpl;

import javax.persistence.PersistenceContext;

/**
 * Created by katgr on 11.12.2017.
 */
@Configuration
@ComponentScan(basePackages = {"pl.gitsolutions.projects.samples.simplequiz.backend.dao",
"pl.gitsolutions.projects.samples.simplequiz.backend.service",
"pl.gitsolutions.projects.samples.simplequiz.backend.executor",
"pl.gitsolutions.projects.samples.simplequiz.backend.endpoint"})
@EntityScan(basePackages = {"pl.gitsolutions.projects.samples.simplequiz.backend.model"})
@EnableJpaRepositories(basePackages = {"pl.gitsolutions.projects.samples.simplequiz.backend.dao"})
@PropertySource("classpath:/application-test.properties")
public class SimpleQuizTestContext {

//    @Bean
//    public TrackRepository trackRepository() {
//        return Mockito.mock(TrackRepository.class);
//    }

//    @Bean
//    public AnswerRepository answerRepository() {
//        return Mockito.mock(AnswerRepository.class);
//    }

//    @Bean
//    public ReadAnswerExecutor readAnswerExecutor() {
//        return Mockito.mock(ReadAnswerExecutor.class);
//    }

//    @Bean
//    public AnswerServiceImpl answerService() {
//        return Mockito.mock(AnswerServiceImpl.class);
//    }

//    @Bean
//    public TrackServiceImpl trackService() {
//        return Mockito.mock(TrackServiceImpl.class);
//    }

}
