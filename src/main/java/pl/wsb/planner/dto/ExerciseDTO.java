package pl.wsb.planner.dto;

import pl.wsb.planner.model.ExerciseType;

public class ExerciseDTO {

	private String name;
	private ExerciseType type;
	private Integer numberOfReps;
	private Integer numberOfSets;
	private Integer restTimeBetweenSets;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ExerciseType getType() {
		return type;
	}
	public void setType(ExerciseType type) {
		this.type = type;
	}
	public Integer getNumberOfReps() {
		return numberOfReps;
	}
	public void setNumberOfReps(Integer numberOfReps) {
		this.numberOfReps = numberOfReps;
	}
	public Integer getNumberOfSets() {
		return numberOfSets;
	}
	public void setNumberOfSets(Integer numberOfSets) {
		this.numberOfSets = numberOfSets;
	}
	public Integer getRestTimeBetweenSets() {
		return restTimeBetweenSets;
	}
	public void setRestTimeBetweenSets(Integer restTimeBetweenSets) {
		this.restTimeBetweenSets = restTimeBetweenSets;
	}
	
}
