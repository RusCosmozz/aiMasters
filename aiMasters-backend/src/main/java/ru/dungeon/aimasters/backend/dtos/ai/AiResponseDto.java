package ru.dungeon.aimasters.backend.dtos.ai;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dungeon.aimasters.backend.dtos.chat.ChatCompletionChoice;

/**
 * @author Ermakov KS
 * @since 05.04.2023
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AiResponseDto {

  String id;
  String object;
  long created;
  String model;
  List<ChatCompletionChoice> choices;
}
