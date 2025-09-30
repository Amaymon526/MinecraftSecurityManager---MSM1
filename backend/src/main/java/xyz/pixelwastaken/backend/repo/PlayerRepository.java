package xyz.pixelwastaken.backend.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pixelwastaken.backend.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}