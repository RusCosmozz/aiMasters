package ru.dungeon.aimasters.backend.repositories;

import org.springframework.stereotype.Repository;
import ru.dungeon.aimasters.backend.domain.entities.PlayerCharacter;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
@Repository
public interface PlayerCharacterRepository extends BaseUUIDRepository<PlayerCharacter> {
}