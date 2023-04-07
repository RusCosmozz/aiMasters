package ru.dungeon.aimasters.backend.dtos.chat;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Locale;
import ru.dungeon.aimasters.backend.exceptions.exceptions.EnumNotFoundException;

/**
 * @author Ermakov KS
 * @since 05.04.2023
 */
public enum ChatRole {
  USER("user"),
  DM("DM"),
  ASSISTANT("assistant"),
  SYSTEM("system");

  private final String text;

  ChatRole(String text) {
    this.text = text;
  }

  @JsonCreator
  public static ChatRole fromValue(String text) {
    for (ChatRole r : ChatRole.values()) {
      if (String.valueOf(r.text).equalsIgnoreCase(text)) {
        return r;
      }
    }
    throw new EnumNotFoundException(text, ChatRole.class);
  }

  @JsonValue
  public String getText() {
    return text.toLowerCase(Locale.ROOT);
  }
}
