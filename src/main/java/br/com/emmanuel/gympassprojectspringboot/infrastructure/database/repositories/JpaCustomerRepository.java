package br.com.emmanuel.gympassprojectspringboot.infrastructure.database.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emmanuel.gympassprojectspringboot.infrastructure.database.entities.CustomerEntity;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {
  Optional<CustomerEntity> findByNameOrEmail(String name, String email);
}
