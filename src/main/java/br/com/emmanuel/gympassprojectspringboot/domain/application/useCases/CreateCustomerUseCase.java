package br.com.emmanuel.gympassprojectspringboot.domain.application.useCases;

import br.com.emmanuel.gympassprojectspringboot.domain.application.repositories.CustomerRepository;
import br.com.emmanuel.gympassprojectspringboot.domain.application.useCases.exceptionsUseCase.AlreadyExists;
import br.com.emmanuel.gympassprojectspringboot.domain.entities.Customer;

public class CreateCustomerUseCase {
  private final CustomerRepository customerGateway;

  public CreateCustomerUseCase(CustomerRepository createCustomer) {
    this.customerGateway = createCustomer;
  }

  public Customer creaCustomer(Customer customer) {
    var customerWithSameEmail = customerGateway.findByEmail(customer.email());

    if (customerWithSameEmail != null) {
      throw new AlreadyExists();
    }

    return customerGateway.createCustomer(customer);
  }
}
