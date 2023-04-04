package ru.dungeon.aimasters.backend.domain.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Ermakov KS
 * @since 04.04.2023
 */
@Data
@Entity
@Table(name = "game_sessions")
@EqualsAndHashCode(callSuper = true)
public class GameSession extends BaseUUIDEntity {

  @Column(name = "name", nullable = false)
  private String name;

  @OneToOne
  @JoinColumn(name = "host_id", referencedColumnName = "id")
  private User host;

  @OneToOne
  @JoinColumn(name = "world_id", referencedColumnName = "id")
  private World world;

  @Column(name = "description")
  private String description;

  @Column(name = "summary")
  private String summary;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "start_date")
  private LocalDateTime startDate;

  @Column(name = "end_date")
  private LocalDateTime endDate;
}
