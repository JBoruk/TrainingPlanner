package pl.wsb.planner.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrainingDTO {
	
	private List<ExerciseDTO> exercises = new ArrayList<>();
	private Integer restBetweenExercises;
	private Integer duration;
	private Date plannedDate;
	
	public List<ExerciseDTO> getExercises() {
		return exercises;
	}
	public void setExercises(List<ExerciseDTO> exercises) {
		this.exercises = exercises;
	}
	public Integer getRestBetweenExercises() {
		return restBetweenExercises;
	}
	public void setRestBetweenExercises(Integer restBetweenExercises) {
		this.restBetweenExercises = restBetweenExercises;
	}
	public Date getPlannedDate() {
		return plannedDate;
	}
	public void setPlannedDate(Date plannedDate) {
		this.plannedDate = plannedDate;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
}
