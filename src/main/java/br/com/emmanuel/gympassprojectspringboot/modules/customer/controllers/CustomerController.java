package br.com.emmanuel.gympassprojectspringboot.modules.customer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emmanuel.gympassprojectspringboot.modules.customer.model.CustomerEntity;
import br.com.emmanuel.gympassprojectspringboot.modules.customer.useCases.CreateCustomerUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CreateCustomerUseCase createCustomerUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CustomerEntity customerEntity) {
    try {
      var result = this.createCustomerUseCase.execute(customerEntity);
      return ResponseEntity.ok().body(result);
    } catch(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
