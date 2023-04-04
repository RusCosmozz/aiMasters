package ru.dungeon.aimasters.backend.services;

import java.util.UUID;
import ru.dungeon.aimasters.backend.dtos.session.GameSessionRequestDto;
import ru.dungeon.aimasters.backend.dtos.session.GameSessionResponseDto;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
public interface GameSessionService {

  GameSessionResponseDto createGameSession(GameSessionRequestDto gameSessionRequestDto, UUID hostId);

  GameSessionResponseDto findGameSessionById(UUID id, UUID hostId);
}
