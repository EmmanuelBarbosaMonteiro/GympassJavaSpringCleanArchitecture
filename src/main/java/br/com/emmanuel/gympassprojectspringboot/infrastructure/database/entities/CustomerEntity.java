package br.com.emmanuel.gympassprojectspringboot.infrastructure.database.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity(name = "customers")
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;

  @Email
  private String email;

  @CreationTimestamp
  private LocalDateTime createdAt;

  public CustomerEntity() {}

  public CustomerEntity(String name, String email) {
    this.name = name;
    this.email = email;
  }
}

