package ir.maktab.dto.mapper.user;

import ir.maktab.data.entity.Expert;
import ir.maktab.dto.ExpertDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpertMapperImpl implements ExpertMapper {

    @Override
    public Expert toExpert(ExpertDto expertDto) {
        return (Expert) new Expert()
                .setId(expertDto.getId())
                .setEmailAddress(expertDto.getEmailAddress())
                .setFullName(expertDto.getFullName())
                .setUserRole(expertDto.getUserRole())
                .setState(expertDto.getState())
                .setPassword(expertDto.getPassword())
                .setDate(expertDto.getDate())
                .setCredit(expertDto.getCredit());
    }

    @Override
    public ExpertDto toExpertDto(Expert expert) {
        return (ExpertDto) new ExpertDto()
                .setId(expert.getId())
                .setEmailAddress(expert.getEmailAddress())
                .setFullName(expert.getFullName())
                .setUserRole(expert.getUserRole())
                .setState(expert.getState())
                .setPassword(expert.getPassword())
                .setDate(expert.getDate())
                .setCredit(expert.getCredit());
    }

    @Override
    public List<Expert> toExperts(List<ExpertDto> expertDtos) {
        List<Expert> experts = new ArrayList<>();
        if (expertDtos.isEmpty()) {
            return experts;
        }
        experts = expertDtos.stream().map(this::toExpert).collect(Collectors.toList());
        return experts;
    }

    @Override
    public List<ExpertDto> toExpertDtos(List<Expert> experts) {
        List<ExpertDto> expertDtos = new ArrayList<>();
        if (experts.isEmpty()) {
            return expertDtos;
        }
        expertDtos = experts.stream().map(this::toExpertDto).collect(Collectors.toList());
        return expertDtos;
    }
}
