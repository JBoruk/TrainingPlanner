package pl.wsb.planner.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "training")
@EntityListeners(AuditingEntityListener.class)
public class Training extends HibernateModel {
	
	@ManyToMany
	@JoinTable(
	  name = "training_exercises", 
	  joinColumns = @JoinColumn(name = "exercise_id"), 
	  inverseJoinColumns = @JoinColumn(name = "training_id"))
	private List<Exercise> exercises = new ArrayList<>();
	private Integer restBetweenExercises;
	private Integer duration;
	private Date plannedDate;
	
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
	public List<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}
