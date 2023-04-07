package ru.dungeon.aimasters.backend.dtos.character;

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
@AllArgsConstructor
@NoArgsConstructor
public class CharacterRequestDto {

  private String name;
  private String race;
  private String raceOverview;
  private String className;
  private String classOverview;
  private String gender;
  private String backstory;
}
