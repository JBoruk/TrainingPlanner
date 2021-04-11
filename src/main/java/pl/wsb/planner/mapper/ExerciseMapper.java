package pl.wsb.planner.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import pl.wsb.planner.dto.ExerciseDTO;
import pl.wsb.planner.model.Exercise;

@Mapper
public interface ExerciseMapper {

	ExerciseDTO exerciseToExerciseDTO(Exercise entity);

	Exercise exerciseDTOToExercise(ExerciseDTO dto);

	List<ExerciseDTO> map(Iterable<Exercise> exercises);
}
