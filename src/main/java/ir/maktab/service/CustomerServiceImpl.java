package ir.maktab.service;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.enums.UserState;
import ir.maktab.data.repository.CustomerRepository;
import ir.maktab.data.repository.CustomerSpecifications;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.mapper.user.CustomerMapper;
import ir.maktab.service.exception.InValidInputException;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper mapper;
    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;


    public CustomerServiceImpl(CustomerMapper mapper, CustomerRepository repository, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.mapper = mapper;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Override
    public void create(CustomerDto dto) {
        Customer customer = mapper.toCustomer(dto);
        //customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setPassword(customer.getPassword());
        customer.setState(UserState.New);
        repository.save(customer);
        //emailService.sendSimpleEmail(dto.getEmailAddress(), "Welcome","This is a welcome email for your!");

    }

    @Override
    public void update(CustomerDto dto) throws NotFoundException {
        Customer customer = mapper.toCustomer(dto);
        if (findCustomerById(customer.getId()).isPresent()) {
            repository.save(customer);
        }
    }

    @Override
    public void remove(CustomerDto dto) throws NotFoundException {
        Customer customer = mapper.toCustomer(dto);
        if (!findCustomerById(customer.getId()).isPresent()) {
            repository.delete(customer);
        }
    }

    @Override
    public Optional<CustomerDto> findCustomerById(Long id) throws NotFoundException {
        Optional<Customer> customer = repository.findById(id);
        if (!customer.isPresent()) {
            throw new NotFoundException("the customer not found by this Id.");
        }
        CustomerDto customerDto = mapper.toCustomerDto(customer.get());
        return Optional.ofNullable(customerDto);
    }

    @Override
    public List<CustomerDto> getAllCustomer() throws NotFoundException {
        List<Customer> customers = repository.findAll();
        if (customers.isEmpty()) {
            throw new NotFoundException("not found any user...");
        } else {
            return mapper.toCustomerDto(customers);
        }
    }


    @Override
    public List<CustomerDto> filterCustomers(CustomerDto customerDto) {
        Pageable pageable = PageRequest.of(customerDto.getPageNumber(), customerDto.getPageSize(),
                Sort.by("Id").ascending());
        Specification<Customer> specification = CustomerSpecifications.filterCustomers(customerDto);

        return repository
                .findAll(Specification.where(specification), pageable)
                .stream().map(mapper::toCustomerDto).collect(Collectors.toList());

    }

    @Override
    public Optional<CustomerDto> getByCredit(Double credit) throws NotFoundException {
        Optional<Customer> customer = repository.findCustomerByCredit(credit);
        if (!customer.isPresent()) {
            throw new NotFoundException("the customer not found by this credit.");
        }
        CustomerDto customerDto = mapper.toCustomerDto(customer.get());
        return Optional.ofNullable(customerDto);
    }

    @Override
    public Customer changePassword(CustomerDto customerDto)  {
        Customer customer = mapper.toCustomer(customerDto);
        //customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setPassword(customer.getPassword());
        repository.save(customer);
        return customer;
    }

    @Override
    public Customer login(CustomerDto customerDto) throws InValidInputException {
        Optional<Customer> customer = repository
                .findCustomerByEmailAddressAndPassword(customerDto.getEmailAddress(), passwordEncoder.encode(customerDto.getPassword()));
        if (!customer.isPresent()) {
            throw new InValidInputException("there is no such customer, try again...");
        }
        return customer.get();
    }

    @Override
    public CustomerDto findCustomerByEmail(String email){
        Optional<Customer> customer = repository.findCustomerByEmailAddress(email);
        if (!customer.isPresent()) {
            return null;
          //  throw new InValidInputException("there is no such customer, try again...");
        }
       // return Optional.ofNullable(mapper.toCustomerDto(customer.get()));
        return mapper.toCustomerDto(customer.get());
    }

    @Override
    public Customer login(String email, String password) throws InValidInputException {
        Optional<Customer> customer = repository.findCustomerByEmailAddressAndPassword(email, password);
        if (customer.isPresent()){
            return customer.get();
        }
        else {
            throw new InValidInputException("there is no such customer, try again...");
        }

    }


}
