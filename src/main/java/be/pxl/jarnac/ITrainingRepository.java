package be.pxl.jarnac;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrainingRepository extends CrudRepository<Training, Integer> {
}
