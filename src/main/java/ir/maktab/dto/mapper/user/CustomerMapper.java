package ir.maktab.dto.mapper.user;

import ir.maktab.data.entity.Customer;
import ir.maktab.dto.CustomerDto;

import java.util.List;


public interface CustomerMapper {

    Customer toCustomer(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);

    List<Customer> toCustomers(List<CustomerDto> customerDto);

    List<CustomerDto> toCustomerDto(List<Customer> customer);
}
