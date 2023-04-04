package ru.dungeon.aimasters.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.dungeon.aimasters.backend.domain.entities.User;
import ru.dungeon.aimasters.backend.domain.entities.World;
import ru.dungeon.aimasters.backend.dtos.user.UserRequestDto;
import ru.dungeon.aimasters.backend.dtos.world.WorldRequestDto;
import ru.dungeon.aimasters.backend.dtos.world.WorldResponseDto;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
@Mapper(componentModel = "spring")
public interface WorldMapper {

  World toWorldEntity(WorldRequestDto worldRequestDto);

  WorldResponseDto toWorldDto(World world);

}
