package pl.wsb.planner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercise")
public class Exercise extends HibernateModel {
	
	@Column
	private String name;
	@Column
	@Enumerated
	private ExerciseType type;
	@Column
	private Integer numberOfReps;
	@Column
	private Integer numberOfSets;
	@Column
	private Integer restTimeBetweenSets;
	@ManyToOne(fetch = FetchType.LAZY)
	private Training training;
	
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public ExerciseType getType() {
		return type;
	}
	public void setType(ExerciseType type) {
		this.type = type;
	}
	
}
