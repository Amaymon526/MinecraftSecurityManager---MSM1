package xyz.pixelwastaken.backend.dto;

import lombok.Data;

@Data
public class CreatePlayerInput {
    private String username;
    private String mcId;
}