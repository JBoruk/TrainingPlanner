package pl.wsb.planner.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "training")
public class Training extends HibernateModel {
	
	@OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Exercise> exercises = new ArrayList<>();
	private Integer restBetweenExercises;
	private Date plannedDate;
	
	public Integer getRestBetweenExercises() {
		return restBetweenExercises;
	}
	public void setRestBetweenExercises(Integer restBetweenExercises) {
		this.restBetweenExercises = restBetweenExercises;
	}
	public List<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	public Date getPlannedDate() {
		return plannedDate;
	}
	public void setPlannedDate(Date plannedDate) {
		this.plannedDate = plannedDate;
	}

}
