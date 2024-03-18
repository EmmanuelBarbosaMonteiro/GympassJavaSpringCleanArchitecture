package br.com.emmanuel.gympassprojectspringboot.infrastructure.http.mappers;

import br.com.emmanuel.gympassprojectspringboot.domain.entities.Customer;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.http.dtos.CreateCustomerRequest;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.http.dtos.CreateCustomerResponse;

public class CustomerDtoMapper {
  public CreateCustomerResponse toResponse(Customer customer) {
    return new CreateCustomerResponse(customer.name(), customer.email());
  }

  public Customer toCustomer(CreateCustomerRequest request) {
    return new Customer(request.name(), request.email());
  }
}
