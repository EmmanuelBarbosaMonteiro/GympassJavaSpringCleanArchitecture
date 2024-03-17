package br.com.emmanuel.gympassprojectspringboot.modules.customer.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emmanuel.gympassprojectspringboot.modules.customer.model.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
  Optional<CustomerEntity> findByNameOrEmail(String name, String email);
}
