package ir.maktab.dto.mapper.user;

import ir.maktab.data.entity.Customer;
import ir.maktab.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        return (Customer) new Customer()
                .setId(customerDto.getId())
                .setEmailAddress(customerDto.getEmailAddress())
                .setFullName(customerDto.getFullName())
                .setUserRole(customerDto.getUserRole())
                .setState(customerDto.getState())
                .setPassword(customerDto.getPassword())
                .setCredit(customerDto.getCredit())
                .setDate(customerDto.getDate())
                .setEnabled(customerDto.isEnabled());
    }

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        return (CustomerDto) new CustomerDto()
                .setId(customer.getId())
                .setEmailAddress(customer.getEmailAddress())
                .setFullName(customer.getFullName())
                .setUserRole(customer.getUserRole())
                .setState(customer.getState())
                .setPassword(customer.getPassword())
                .setCredit(customer.getCredit())
                .setDate(customer.getDate())
                .setEnabled(customer.isEnabled());
    }

    @Override
    public List<Customer> toCustomers(List<CustomerDto> customerDtos) {
        List<Customer> customers = new ArrayList<>();
        if (customerDtos.isEmpty()) {
            return customers;
        }
        customers = customerDtos.stream().map(this::toCustomer).collect(Collectors.toList());
        return customers;
    }

    @Override
    public List<CustomerDto> toCustomerDto(List<Customer> customers) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        if (customers.isEmpty()) {
            return customerDtos;
        }
        customerDtos = customers.stream().map(this::toCustomerDto).collect(Collectors.toList());
        return customerDtos;
    }
}
