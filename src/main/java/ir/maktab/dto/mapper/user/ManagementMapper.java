package ir.maktab.dto.mapper.user;

import ir.maktab.data.entity.Manager;
import ir.maktab.dto.ManagerDto;

public interface ManagementMapper {

    Manager toManagement(ManagerDto managerDto);

    ManagerDto toManagementDto(Manager manager);

}
