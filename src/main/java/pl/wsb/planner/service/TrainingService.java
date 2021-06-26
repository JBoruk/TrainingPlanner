package pl.wsb.planner.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.wsb.planner.dto.TrainingDTO;
import pl.wsb.planner.mapper.TrainingMapper;
import pl.wsb.planner.model.Exercise;
import pl.wsb.planner.model.Training;
import pl.wsb.planner.repository.ExerciseRepository;
import pl.wsb.planner.repository.TrainingRepository;

@Service
public class TrainingService {
	
	private TrainingMapper trainingMapper = Mappers.getMapper(TrainingMapper.class);
	
	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private ExerciseRepository exerciseRepository;

	public Training updateExistingTraining(TrainingDTO trainingDto, Long id) {
		Training training = trainingRepository.findById(id).orElse(null);
		
		trainingMapper.updateTrainingFromDto(trainingDto, training);
		
		List<Exercise> exercises = training.getExercises()
				.stream()
				.map(exercise -> exerciseRepository.findFirstByName(exercise.getName()))
				.collect(Collectors.toList());
		
		training.setExercises(exercises);
		
		return trainingRepository.save(training);
	}
	
	public void removeTraining(Long id) {
		trainingRepository.deleteById(id);
	}
	
	public Training createTraining(TrainingDTO trainingDto) {
		Training training = trainingMapper.trainingDTOToTraining(trainingDto);
		
		List<Exercise> exercises = training.getExercises()
				.stream()
				.map(exercise -> exerciseRepository.findFirstByName(exercise.getName()))
				.collect(Collectors.toList());
		
		training.setExercises(exercises);
		
		return trainingRepository.save(training);
	}
	
	public Iterable<Training> getTrainings(Date fromDate, Date toDate) {
		if (fromDate != null && toDate != null) {
			return trainingRepository.findAllWithPlannedDateBetween(fromDate, toDate);
		} else if (fromDate != null) {
			return trainingRepository.findAllWithPlannedDateAfter(fromDate);
		} else if (toDate != null) {
			return trainingRepository.findAllWithPlannedDateBefore(toDate);
		}
		
		return trainingRepository.findAll();
	}
	
	public Training getSingleTraining(Long id) {
		return trainingRepository.findById(id).orElse(null);
	}
}
