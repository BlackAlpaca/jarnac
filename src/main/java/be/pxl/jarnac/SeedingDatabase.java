package be.pxl.jarnac;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class SeedingDatabase {
        @Bean
        public CommandLineRunner createTrainings(ITrainingRepository trainingRepository){
            return (String... args) -> {

               Training training = new Training();
               training.setAdult(true);
               training.setLocation("Leopoldsburg");
               training.setTitle("Training Dinsdag");
               training.setNecessities("Niets");
               training.setLocalDateTime(LocalDateTime.now());

                Training training2 = new Training();
                training2.setAdult(false);
                training2.setLocation("Heppen");
                training2.setTitle("Training Donderdag");
                training2.setNecessities("Loopschoenen");
                training2.setLocalDateTime(LocalDateTime.now());


                trainingRepository.saveAll(Arrays.asList(training, training2));
            };
        }
}
