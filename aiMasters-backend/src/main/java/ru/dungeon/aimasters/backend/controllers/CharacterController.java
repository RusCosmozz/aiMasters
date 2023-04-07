package ru.dungeon.aimasters.backend.controllers;

import static ru.dungeon.aimasters.backend.utils.JsonUtils.fromJson;
import static ru.dungeon.aimasters.backend.utils.JsonUtils.toJson;

import java.util.UUID;
import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.dungeon.aimasters.backend.dtos.ai.AiResponseDto;
import ru.dungeon.aimasters.backend.dtos.character.CharacterRequestDto;
import ru.dungeon.aimasters.backend.dtos.character.CharacterResponseDto;
import ru.dungeon.aimasters.backend.dtos.chat.MessageContent;
import ru.dungeon.aimasters.backend.services.AiService;
import ru.dungeon.aimasters.backend.services.CharacterService;

/**
 * @author Ermakov KS
 * @since 06.04.2023
 */
@Slf4j
@RestController
@RequestMapping("/api/users/{userId}/world/{worldId}/characters")
@AllArgsConstructor
public class CharacterController {

  private final CharacterService characterService;
  private final AiService aiService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CharacterResponseDto createPlayerCharacter(
      @PathVariable UUID userId,
      @PathVariable UUID worldId,
      HttpSession httpSession) {

    log.info("Запрос на генерацию нового персонажа");
    AiResponseDto aiResponseDto = aiService.createCharacter(httpSession);
    MessageContent messageContent = aiResponseDto.getChoices().get(0).getMessageContent();
    log.info("{}", toJson(messageContent));

    String characterJson = messageContent.getMessage();
    CharacterRequestDto characterRequestDto = fromJson(characterJson, CharacterRequestDto.class);
    return characterService.savePlayerCharacter(characterRequestDto, userId, worldId);
  }
}
