package br.com.emmanuel.gympassprojectspringboot.domain.application.useCases.exceptionsUseCase;

import br.com.emmanuel.gympassprojectspringboot.core.UseCaseError;

public class AlreadyExists extends RuntimeException implements UseCaseError {
  public AlreadyExists() {
    super("Already exists");
  }
}
