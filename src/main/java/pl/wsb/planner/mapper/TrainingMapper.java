package pl.wsb.planner.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import pl.wsb.planner.dto.TrainingDTO;
import pl.wsb.planner.model.Training;

@Mapper
public interface TrainingMapper {

	TrainingDTO trainingToTrainingDTO(Training entity);

	Training trainingDTOToTraining(TrainingDTO dto);

	List<TrainingDTO> map(Iterable<Training> trainings);

}
