package br.com.emmanuel.gympassprojectspringboot.infrastructure.database.mappers;

import br.com.emmanuel.gympassprojectspringboot.domain.entities.Customer;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.database.entities.CustomerEntity;

public class CustomerEntityMapper {
  public CustomerEntity toEntity(Customer customerDomainObj) {
    return new CustomerEntity(customerDomainObj.name(), customerDomainObj.email());
  }

  public Customer toDomainObj(CustomerEntity customerEntity) {
    return new Customer(customerEntity.getName(), customerEntity.getEmail());
  }
}