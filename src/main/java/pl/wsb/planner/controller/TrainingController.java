package pl.wsb.planner.controller;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.wsb.planner.dto.TrainingDTO;
import pl.wsb.planner.mapper.TrainingMapper;
import pl.wsb.planner.repository.TrainingRepository;

@RestController("/training")
public class TrainingController {
	
	private static final Logger logger = LogManager.getLogger("HelloWorld");
	
	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private TrainingMapper trainingMapper;
	
	@GetMapping("")
	public ResponseEntity<Iterable<TrainingDTO>> getTrainings(@RequestParam(required = false) Date fromDate, @RequestParam(required = false) Date toDate) {
		
		if (fromDate != null && toDate != null) {
			logger.debug("Retrieving trainings with fromDate: " + fromDate.toString() + ", toDate: " + toDate.toString());
			return ResponseEntity.ok(trainingMapper.map(trainingRepository.findAllWithPlannedDateBetween(fromDate, toDate)));
		} else if (fromDate != null) {
			logger.debug("Retrieving trainings with fromDate: " + fromDate.toString());
			return ResponseEntity.ok(trainingMapper.map(trainingRepository.findAllWithPlannedDateAfter(fromDate)));
		} else if (toDate != null) {
			logger.debug("Retrieving trainings with toDate: " + toDate.toString());
			return ResponseEntity.ok(trainingMapper.map(trainingRepository.findAllWithPlannedDateBefore(toDate)));
		}
		
		logger.debug("Retrieving all trainings");
		
		return ResponseEntity.ok(trainingMapper.map(trainingRepository.findAll()));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TrainingDTO> getTrainingById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(trainingMapper.trainingToTrainingDTO(trainingRepository.findById(id).orElse(null)));
	}
	
}
