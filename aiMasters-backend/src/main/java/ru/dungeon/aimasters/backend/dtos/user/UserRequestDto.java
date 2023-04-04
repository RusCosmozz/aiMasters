package ru.dungeon.aimasters.backend.dtos.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

  @NotEmpty(message = "Username is required.")
  @Size(min = 3, max = 255, message = "Username must be between 3 and 255 characters.")
  private String username;

  @NotEmpty(message = "Email is required.")
  @Email(message = "Email must be a valid email address.")
  private String email;

  @NotEmpty(message = "Password is required.")
  @Size(min = 6, max = 255, message = "Password must be between 6 and 255 characters.")
  private String password;
}
