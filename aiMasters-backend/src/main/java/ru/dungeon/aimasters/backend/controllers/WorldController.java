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
import ru.dungeon.aimasters.backend.dtos.world.WorldRequestDto;
import ru.dungeon.aimasters.backend.dtos.world.WorldResponseDto;
import ru.dungeon.aimasters.backend.services.WorldService;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
@RestController
@RequestMapping("/api/worlds")
@AllArgsConstructor
public class WorldController {

  private final WorldService worldService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public WorldResponseDto createWorld(@RequestBody WorldRequestDto worldRequestDto) {
    return worldService.createWorld(worldRequestDto);
  }

  @GetMapping("/{worldId}")
  public WorldResponseDto getWorldById(@PathVariable UUID worldId) {
    return worldService.findWorldById(worldId);
  }
}
