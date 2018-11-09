package be.pxl.jarnac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TrainingService {

    @Autowired
    private ITrainingRepository trainingRepository;


    @GetMapping(path = "/training/all")
    private ResponseEntity getAllTrainings(){

        List<Training> trainings = new ArrayList<>();

       trainingRepository.findAll().forEach(trainings::add);

        Map<String, List<Training>> resultmap = new HashMap<>();

        resultmap.put("trainings", trainings);

        return ResponseEntity.ok(resultmap);
    }


    @PostMapping(path = "/training/new")
    private ResponseEntity postTraining(@RequestParam(name = "title")String title,
                                        @RequestParam(name = "necessities")String necessities,
                                        @RequestParam(name = "location")String location,
                                        @RequestParam(name = "localDateTime")String localDateTime,
                                        @RequestParam(name = "adult")String adult){
       try{


           Training training = new Training();

           training.setTitle(title);
           training.setNecessities(necessities);
           training.setLocation(location);
           training.setLocalDateTime(LocalDateTime.of(Integer.parseInt(localDateTime.split("/")[2]),Integer.parseInt(localDateTime.split("/")[1]),Integer.parseInt(localDateTime.split("/")[0]), 0, 0));
           training.setAdult(Boolean.valueOf(adult));
           trainingRepository.save(training);

           return ResponseEntity.ok().build();
       } catch (Exception ex){
           return ResponseEntity.badRequest().build();
       }
    }

}
