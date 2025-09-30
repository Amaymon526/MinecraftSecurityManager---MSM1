package xyz.pixelwastaken.backend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.pixelwastaken.backend.model.player.Player;
import xyz.pixelwastaken.backend.model.roles.Role;
import xyz.pixelwastaken.backend.repo.PlayerRepository;
import xyz.pixelwastaken.backend.repo.RoleRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(UUID id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + id));
    }

    @Override
    public Player create(String username, String mcId) {
        Player p = new Player();
        p.setUsername(username);
        p.setMcUuid(mcId);
        return playerRepository.save(p);
    }

    @Override
    public boolean delete(UUID id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAll() {
        playerRepository.deleteAll();
        return true;
    }

    @Override
    public Player findByMcId(String mcId) {
        return playerRepository.findPlayerByMcUuid(mcId);
    }

    @Override
    @Transactional
    public Player assignRole(UUID playerId, UUID roleId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + playerId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));

        player.getRoles().add(role);
        return playerRepository.save(player);
    }

    @Override
    @Transactional
    public Player removeRole(UUID playerId, UUID roleId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + playerId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));

        player.getRoles().remove(role);
        return playerRepository.save(player);
    }
}
