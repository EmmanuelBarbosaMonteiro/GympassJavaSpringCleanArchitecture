package br.com.emmanuel.gympassprojectspringboot.infrastructure.http.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDto {
  private String message;
  private String field;
}
