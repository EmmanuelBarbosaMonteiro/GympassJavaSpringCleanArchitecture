package br.com.emmanuel.gympassprojectspringboot.domain.application.useCases;

import br.com.emmanuel.gympassprojectspringboot.domain.application.repositories.CustomerRepository;
import br.com.emmanuel.gympassprojectspringboot.domain.entities.Customer;

public class CreateCustomerUseCase {
  private final CustomerRepository customerGateway;

  public CreateCustomerUseCase(CustomerRepository createCustomer) {
    this.customerGateway = createCustomer;
  }

  public Customer creaCustomer(Customer customer) {
    return customerGateway.createCustomer(customer);
  }
}
