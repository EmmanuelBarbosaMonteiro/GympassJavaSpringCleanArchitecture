package br.com.emmanuel.gympassprojectspringboot.domain.application.repositories;

import br.com.emmanuel.gympassprojectspringboot.domain.entities.Customer;

public interface CustomerRepository {
  Customer createCustomer(Customer customer);
}
