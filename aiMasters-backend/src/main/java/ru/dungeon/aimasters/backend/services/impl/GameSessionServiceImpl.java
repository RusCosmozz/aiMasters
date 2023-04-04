package ru.dungeon.aimasters.backend.services.impl;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dungeon.aimasters.backend.domain.entities.GameSession;
import ru.dungeon.aimasters.backend.domain.entities.User;
import ru.dungeon.aimasters.backend.domain.entities.World;
import ru.dungeon.aimasters.backend.dtos.session.GameSessionRequestDto;
import ru.dungeon.aimasters.backend.dtos.session.GameSessionResponseDto;
import ru.dungeon.aimasters.backend.exceptions.exceptions.EntityNotFoundException;
import ru.dungeon.aimasters.backend.mappers.GameSessionMapper;
import ru.dungeon.aimasters.backend.repositories.GameSessionRepository;
import ru.dungeon.aimasters.backend.repositories.UserRepository;
import ru.dungeon.aimasters.backend.repositories.WorldRepository;
import ru.dungeon.aimasters.backend.services.GameSessionService;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class GameSessionServiceImpl implements GameSessionService {

  private UserRepository userRepository;
  private WorldRepository worldRepository;
  private GameSessionRepository gameSessionRepository;
  private GameSessionMapper gameSessionMapper;

  @Override
  @Transactional
  public GameSessionResponseDto createGameSession(GameSessionRequestDto gameSessionRequestDto, UUID hostId) {
    User host = getHostIfExists(hostId);
    World world = getWorldIfExists(gameSessionRequestDto.getWorldId());
    GameSession gameSessionEntity = gameSessionMapper.toGameSessionEntity(gameSessionRequestDto);
    gameSessionEntity.setHost(host);
    gameSessionEntity.setWorld(world);
    GameSession savedGameSession = gameSessionRepository.save(gameSessionEntity);
    return gameSessionMapper.toGameSessionResponseDto(savedGameSession);
  }

  @Override
  public GameSessionResponseDto findGameSessionById(UUID id, UUID hostId) {
    //todo
    return null;
  }

  private User getHostIfExists(UUID userId) {
    return userRepository.findById(userId)
                         .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
  }

  private World getWorldIfExists(UUID worldId) {
    return worldRepository.findById(worldId)
                          .orElseThrow(() -> new EntityNotFoundException("World not found with ID: " + worldId));
  }
}
