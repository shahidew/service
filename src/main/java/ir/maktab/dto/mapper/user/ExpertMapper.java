package ir.maktab.dto.mapper.user;

import ir.maktab.data.entity.Expert;
import ir.maktab.dto.ExpertDto;

import java.util.List;

public interface ExpertMapper {

    Expert toExpert(ExpertDto expertDto);

    ExpertDto toExpertDto(Expert expert);

    List<Expert> toExperts(List<ExpertDto> expertDtos);

    List<ExpertDto> toExpertDtos(List<Expert> expert);
}
