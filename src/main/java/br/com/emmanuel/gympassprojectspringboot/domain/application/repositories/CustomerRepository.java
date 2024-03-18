package br.com.emmanuel.gympassprojectspringboot.domain.application.repositories;

import java.util.Optional;

import br.com.emmanuel.gympassprojectspringboot.domain.entities.Customer;

public interface CustomerRepository {
  Optional<Customer> findByEmail(String email);
  Customer createCustomer(Customer customer);
}
