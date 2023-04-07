package ru.dungeon.aimasters.backend.dtos.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ermakov KS
 * @since 06.04.2023
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageContent {

  private ChatRole role;
  private ChatAction action;
  private String message;
}
