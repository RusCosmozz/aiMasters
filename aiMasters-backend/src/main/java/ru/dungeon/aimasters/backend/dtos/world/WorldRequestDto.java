package ru.dungeon.aimasters.backend.dtos.world;

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
public class WorldRequestDto {

  private String worldName;
  private String description;
  //todo больше параметров мира для генерации, может быть использовать HashMap
}
