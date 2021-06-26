package pl.wsb.planner.service;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wsb.planner.dto.ExerciseDTO;
import pl.wsb.planner.mapper.ExerciseMapper;
import pl.wsb.planner.model.Exercise;
import pl.wsb.planner.repository.ExerciseRepository;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	private ExerciseMapper exerciseMapper = Mappers.getMapper(ExerciseMapper.class);
	
	public List<ExerciseDTO> getExercises() {
		Iterable<Exercise> iterable = exerciseRepository.findAll();
		List<ExerciseDTO> exercises = new ArrayList<>();
		iterable.forEach(ex -> exercises.add(exerciseMapper.exerciseToExerciseDTO(ex)));
		
		return exercises;
	}
	
	public void addExercises(List<String> names) {
		for (String name : names) {
			Exercise dbExercise = exerciseRepository.findFirstByName(name);
			
			if (dbExercise == null) {
				Exercise newExercise = new Exercise();
				newExercise.setName(name);
				exerciseRepository.save(newExercise);
			}
		}
	}
	
}
