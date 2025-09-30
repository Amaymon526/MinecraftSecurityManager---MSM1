package xyz.pixelwastaken.backend.model.roles;

import jakarta.persistence.*;
import lombok.*;
import xyz.pixelwastaken.backend.model.player.Player;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bans")
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player bannedPlayer;

    private String reason;
    private Instant createdAt;
    private Instant expiresAt;  // null = permanent

    @ManyToOne
    @JoinColumn(name = "issued_by")
    private Player issuedBy;
}
