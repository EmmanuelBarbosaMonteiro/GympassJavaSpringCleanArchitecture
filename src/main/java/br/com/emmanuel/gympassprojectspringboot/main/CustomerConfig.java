package br.com.emmanuel.gympassprojectspringboot.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.emmanuel.gympassprojectspringboot.domain.application.repositories.CustomerRepository;
import br.com.emmanuel.gympassprojectspringboot.domain.application.useCases.CreateCustomerUseCase;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.database.gateways.CustomerRepositoryGateway;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.database.mappers.CustomerEntityMapper;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.database.repositories.JpaCustomerRepository;
import br.com.emmanuel.gympassprojectspringboot.infrastructure.http.mappers.CustomerDtoMapper;

@Configuration
public class CustomerConfig {
  @Bean
  CreateCustomerUseCase createCustomerUseCase(CustomerRepository customerRepository) {
    return new CreateCustomerUseCase(customerRepository);
  }

  @Bean
  CustomerRepository customerRepository(JpaCustomerRepository jpaCustomerRepository, CustomerEntityMapper customerEntityMapper) {
    return new CustomerRepositoryGateway(jpaCustomerRepository, customerEntityMapper);
  }

  @Bean
  CustomerEntityMapper customerEntityMapper() {
    return new CustomerEntityMapper();
  }

  @Bean
  CustomerDtoMapper customerDtoMapper() {
    return new CustomerDtoMapper();
  }
}
