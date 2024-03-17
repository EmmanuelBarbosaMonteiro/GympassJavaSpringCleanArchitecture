package br.com.emmanuel.gympassprojectspringboot.modules.customer.useCases.exceptionsUseCase;

public class AlreadyExists extends RuntimeException {
  public AlreadyExists() {
    super("Already exists");
  }
}
