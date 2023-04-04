package ru.dungeon.aimasters.backend.controllers;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.dungeon.aimasters.backend.domain.entities.User;
import ru.dungeon.aimasters.backend.dtos.user.UserRequestDto;
import ru.dungeon.aimasters.backend.dtos.user.UserResponseDto;
import ru.dungeon.aimasters.backend.mappers.UserMapper;
import ru.dungeon.aimasters.backend.services.UserService;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
    return userService.register(userRequestDto);
  }

  // todo нормальная авторизация и возвращение токена(?)
  @PostMapping("/login")
  public void login(@RequestParam String email, @RequestParam String password) {
    userService.login(email, password);
  }

  @GetMapping("/{userId}")
  public UserResponseDto getUserById(@PathVariable UUID userId) {
    return userService.findUserById(userId);
  }

  @PutMapping("/{userId}")
  public UserResponseDto updateUser(@PathVariable UUID userId, @RequestBody UserRequestDto userUpdateDto) {
    return userService.updateUser(userId, userUpdateDto);
  }

  @DeleteMapping("/{userId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUser(@PathVariable UUID userId) {
    userService.deleteUser(userId);
  }
}
