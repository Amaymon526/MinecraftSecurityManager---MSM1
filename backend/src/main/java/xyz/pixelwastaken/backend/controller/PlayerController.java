package xyz.pixelwastaken.backend.controller;

import org.springframework.web.bind.annotation.*;
import xyz.pixelwastaken.backend.model.Player;
import xyz.pixelwastaken.backend.repo.PlayerRepository;

import java.util.List;


@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }
}
