package pl.wsb.planner.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.wsb.planner.model.Training;

public interface TrainingRepository extends CrudRepository<Training, Long> {
	
	@Query("select t from Training t where t.plannedDate <= :date")
    List<Training> findAllWithPlannedDateBefore(@Param("date") Date date);
	
	@Query("select t from Training t where t.plannedDate >= :date")
	List<Training> findAllWithPlannedDateAfter(@Param("date") Date date);
	
	@Query("select t from Training t where t.plannedDate >= :from and t.plannedDate <= :to")
	List<Training> findAllWithPlannedDateBetween(@Param("from") Date from, @Param("to") Date to);
}
