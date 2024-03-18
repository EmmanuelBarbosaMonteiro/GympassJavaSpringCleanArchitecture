package br.com.emmanuel.gympassprojectspringboot.infrastructure.database.gateways;

import br.com.emmanuel.gympassprojectspringboot.domain.application.repositories.CustomerRepository;
import br.com.emmanuel.gympassprojectspringboot.domain.entities.Customer;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.database.entities.CustomerEntity;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.database.mappers.CustomerEntityMapper;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.database.repositories.JpaCustomerRepository;

public class CustomerRepositoryGateway implements CustomerRepository {

  private final JpaCustomerRepository jpaCustomerRepository;
  private final CustomerEntityMapper customerEntityMapper;

  public CustomerRepositoryGateway(JpaCustomerRepository jpaCustomerRepository, CustomerEntityMapper customerEntityMapper) {
    this.jpaCustomerRepository = jpaCustomerRepository;
    this.customerEntityMapper = customerEntityMapper;
  }

  @Override
  public Customer createCustomer(Customer customerDomainObj) {
    CustomerEntity customerEntity = customerEntityMapper.toEntity(customerDomainObj);
    CustomerEntity savedEntity = jpaCustomerRepository.save(customerEntity);
    
    return customerEntityMapper.toDomainObj(savedEntity);
  }
}
