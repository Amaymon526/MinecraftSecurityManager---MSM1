package xyz.pixelwastaken.backend.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pixelwastaken.backend.model.player.Player;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {


    Player findPlayerByMcUuid(String mcUuid);


}