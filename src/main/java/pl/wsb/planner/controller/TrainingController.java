package pl.wsb.planner.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.wsb.planner.dto.TrainingDTO;
import pl.wsb.planner.model.Training;
import pl.wsb.planner.service.TrainingService;

@Controller
@RequestMapping("/training")
public class TrainingController {
	
	@Autowired
	private TrainingService trainingService;
	
	@GetMapping
	public ResponseEntity<Iterable<Training>> getTrainings(@RequestParam(required = false) Date fromDate, @RequestParam(required = false) Date toDate) {
		return ResponseEntity.ok(trainingService.getTrainings(fromDate, toDate));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Training> getTrainingById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(trainingService.getSingleTraining(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Training> editTraining(@RequestBody TrainingDTO training, @PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(trainingService.updateExistingTraining(training, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> removeTraining(@PathVariable(name = "id") Long id) {
		trainingService.removeTraining(id);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	@PostMapping
	public ResponseEntity<Training> createTraining(@RequestBody TrainingDTO training) {
		return ResponseEntity.ok(trainingService.createTraining(training));
	}
	
}
