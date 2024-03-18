package br.com.emmanuel.gympassprojectspringboot.infrastructure.http.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
  
  private String message;
  private String field;
}
