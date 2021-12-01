package ir.maktab.web;


import ir.maktab.dto.ApiErrorDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("expertList")
public class ExpertRestController {
    private final ExpertService service;

    public ExpertRestController(ExpertService service) {
        this.service = service;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> searchExperts() throws NotFoundException {
        return new ResponseEntity<>(service.getAllExpert(), HttpStatus.OK);
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<Object> bindExceptionHandler(BindException ex) {
        List<String> validationErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> validationErrors.add(error.getField() + ": " + error.getDefaultMessage()));
        ApiErrorDto dto = new ApiErrorDto(HttpStatus.BAD_REQUEST, ex.getClass().getName(), validationErrors);
        return new ResponseEntity<>(dto, dto.getStatus());
    }
}
