package ir.maktab.web;

import ir.maktab.dto.ApiErrorDto;
import ir.maktab.service.CustomerService;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customerList")
public class CustomerRestController {
    private final CustomerService service;

    public CustomerRestController(CustomerService service) {
        this.service = service;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getCustomers() throws NotFoundException {
        return new ResponseEntity<>(service.getAllCustomer(), HttpStatus.OK);
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<Object> bindExceptionHandler(BindException ex) {
        List<String> validationErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> validationErrors.add(error.getField() + ": " + error.getDefaultMessage()));
        ApiErrorDto dto = new ApiErrorDto(HttpStatus.BAD_REQUEST, ex.getClass().getName(), validationErrors);
        return new ResponseEntity<>(dto, dto.getStatus());
    }
}
