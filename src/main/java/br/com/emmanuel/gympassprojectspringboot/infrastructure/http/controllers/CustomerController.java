package br.com.emmanuel.gympassprojectspringboot.infrastructure.http.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emmanuel.gympassprojectspringboot.domain.application.useCases.CreateCustomerUseCase;
import br.com.emmanuel.gympassprojectspringboot.domain.entities.Customer;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.http.dtos.CreateCustomerRequest;
// import br.com.emmanuel.gympassprojectspringboot.infrastructure.http.dtos.CreateCustomerResponse; TODO
import br.com.emmanuel.gympassprojectspringboot.infrastructure.http.mappers.CustomerDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("customer")
public class CustomerController {
  private final CreateCustomerUseCase createCustomerUseCase;
  private final CustomerDtoMapper customerDtoMapper;

  public CustomerController(CreateCustomerUseCase createCustomerUseCase, CustomerDtoMapper customerDtoMapper) {
    this.createCustomerUseCase = createCustomerUseCase;
    this.customerDtoMapper = customerDtoMapper;
  }
  

  @PostMapping
  public ResponseEntity<?> create(@Valid @RequestBody CreateCustomerRequest request) {
    try {
      Customer customerDomainObj = customerDtoMapper.toCustomer(request);
      Customer customer = createCustomerUseCase.creaCustomer(customerDomainObj);
      var result = customerDtoMapper.toResponse(customer);

      return ResponseEntity.ok().body(result);
    } catch(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
