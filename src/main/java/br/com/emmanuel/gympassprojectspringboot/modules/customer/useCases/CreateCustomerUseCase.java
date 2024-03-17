package br.com.emmanuel.gympassprojectspringboot.modules.customer.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emmanuel.gympassprojectspringboot.modules.customer.model.CustomerEntity;
import br.com.emmanuel.gympassprojectspringboot.modules.customer.repository.CustomerRepository;
import br.com.emmanuel.gympassprojectspringboot.modules.customer.useCases.exceptionsUseCase.AlreadyExists;

@Service
public class CreateCustomerUseCase {

  @Autowired
  private CustomerRepository customerRepository;

  public CustomerEntity execute(CustomerEntity customerEntity) {
    this.customerRepository.findByNameOrEmail(customerEntity.getName(),
        customerEntity.getEmail()).ifPresent(customer -> {
          throw new AlreadyExists();
        });

        return this.customerRepository.save(customerEntity);
  }
}
