package pl.wsb.planner.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.TextNode;

import pl.wsb.planner.dto.ExerciseDTO;
import pl.wsb.planner.service.ExerciseService;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@GetMapping
	public ResponseEntity<List<ExerciseDTO>> getExercises() {
		return ResponseEntity.ok(exerciseService.getExercises());
	}
	
	@PostMapping
	public ResponseEntity<Boolean> createExercise(@RequestBody TextNode name) {
		exerciseService.addExercises(Arrays.asList(name.asText()));
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
}
