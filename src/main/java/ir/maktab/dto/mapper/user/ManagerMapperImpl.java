package ir.maktab.dto.mapper.user;

import ir.maktab.data.entity.Manager;
import ir.maktab.dto.ManagerDto;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapperImpl implements ManagementMapper {
    @Override
    public Manager toManagement(ManagerDto managerDto) {
        return new Manager()
                .setFullName(managerDto.getFullName())
                .setId(managerDto.getId())
                .setPassword(managerDto.getPassword())
                .setEmailAddress(managerDto.getEmailAddress());
    }

    @Override
    public ManagerDto toManagementDto(Manager manager) {
        return new ManagerDto()
                .setId(manager.getId())
                .setFullName(manager.getFullName())
                .setPassword(manager.getPassword())
                .setEmailAddress(manager.getEmailAddress());
    }
}
