package ru.dungeon.aimasters.backend.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ermakov KS
 * @since 05.04.2023
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ai")
public class AiConfig {

  private String apiBaseUrl;
  private String apiKey;
}
