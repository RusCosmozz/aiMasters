package ru.dungeon.aimasters.backend.controllers;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.dungeon.aimasters.backend.dtos.session.GameSessionRequestDto;
import ru.dungeon.aimasters.backend.dtos.session.GameSessionResponseDto;
import ru.dungeon.aimasters.backend.services.GameSessionService;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
@RestController
@RequestMapping("/api/users/{userId}/game-sessions")
@AllArgsConstructor
public class GameSessionController {

  private final GameSessionService gameSessionService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GameSessionResponseDto createGameSession(
      @PathVariable UUID userId,
      @RequestBody GameSessionRequestDto gameSessionRequestDto) {

    return gameSessionService.createGameSession(gameSessionRequestDto, userId);
  }

  @GetMapping("/{gameSessionId}")
  public GameSessionResponseDto getGameSessionById(@PathVariable UUID userId, @PathVariable UUID gameSessionId) {
    // You may use the userId variable here if you want to enforce that the user can only see their own game sessions.
    return gameSessionService.findGameSessionById(gameSessionId, userId);
  }
}
