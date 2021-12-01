package ir.maktab.service;


import ir.maktab.data.entity.Customer;
import ir.maktab.dto.CustomerDto;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void create(CustomerDto dto);

    void update(CustomerDto dto) throws NotFoundException;

    void remove(CustomerDto dto) throws NotFoundException;

    Optional<CustomerDto> findCustomerById(Long id) throws NotFoundException;

    List<CustomerDto> getAllCustomer() throws NotFoundException;

    List<CustomerDto> filterCustomers(CustomerDto customerDto);

    Optional<CustomerDto> getByCredit(Double credit) throws NotFoundException;

    Customer changePassword(CustomerDto customerDto);

    Customer login(CustomerDto customerDto) throws NotFoundException, InValidInputException;

    CustomerDto findCustomerByEmail(String email) throws InValidInputException;

    Customer login(String email, String password) throws InValidInputException;
}
