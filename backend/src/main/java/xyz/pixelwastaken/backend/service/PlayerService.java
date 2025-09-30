package xyz.pixelwastaken.backend.service;

import xyz.pixelwastaken.backend.model.player.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerService {


    List<Player> findAll();

    Player findById(UUID id);

    Player findByMcId(String  mcId);



    Player create(String username, String mcId);

    boolean delete(UUID id);

    boolean deleteAll();

    Player assignRole(UUID playerId, UUID roleId);
    Player removeRole(UUID playerId, UUID roleId);

}