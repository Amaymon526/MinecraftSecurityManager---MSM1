package xyz.pixelwastaken.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import xyz.pixelwastaken.backend.dto.CreatePlayerInput;
import xyz.pixelwastaken.backend.model.player.Player;
import xyz.pixelwastaken.backend.service.PlayerService;

import java.util.List;
import java.util.UUID;


@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @QueryMapping
    public List<Player> findPlayers() {
        return playerService.findAll();
    }

    @QueryMapping
    public Player playerById(@Argument UUID id) {
        return playerService.findById(id);
    }

    @QueryMapping
    public Player playerByMcUuid(@Argument String mcId) {
        return playerService.findByMcId(mcId);
    }




    @MutationMapping
    public Player createPlayer(@Argument CreatePlayerInput input) {
        return playerService.create(input.getUsername(), input.getMcId());
    }

    @MutationMapping()
    public boolean deletePlayer(@Argument UUID id) {
        return playerService.delete(id);
    }

    @MutationMapping()
    public boolean deleteAllPlayers() {
        return playerService.deleteAll();
    }

//    @MutationMapping()
//    public boolean kickPlayer(@Argument UUID id) {
//        return playerService.deleteAll();
//    }


    @MutationMapping()
    public boolean assignRole(@Argument UUID id, @Argument UUID roleId) {
        return playerService.deleteAll();
    }

    @MutationMapping()
    public boolean removeRole(@Argument UUID id, @Argument UUID roleId) {
        return playerService.deleteAll();
    }






}
