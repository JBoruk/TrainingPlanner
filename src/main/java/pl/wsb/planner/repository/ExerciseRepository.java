package pl.wsb.planner.repository;

import org.springframework.data.repository.CrudRepository;

import pl.wsb.planner.model.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

}
