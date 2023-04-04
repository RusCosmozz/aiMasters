package ru.dungeon.aimasters.backend.domain.entities;


import javax.persistence.*;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "player_characters")
public class PlayerCharacter extends BaseUUIDEntity {

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "game_session_id", referencedColumnName = "id")
  private GameSession gameSession;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "race", nullable = false)
  //todo енам
  private String race;

  @Column(name = "class", nullable = false)
  //todo енам
  private String className;

  @Column(name = "gender", nullable = false)
  //todo енам
  private String gender;

  @Column(name = "level", nullable = false)
  private Integer level;

  @Column(name = "attributes", nullable = false)
  //todo наверное атрибуты будут жестко заданы и их хранить в отдельном классе
  //todo как хранить спелы?
  private String attributes;

  @Column(name = "backstory")
  private String backstory;
}
