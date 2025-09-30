package xyz.pixelwastaken.backend.model.player;

import jakarta.persistence.*;
import lombok.*;
import xyz.pixelwastaken.backend.model.roles.Role;
import xyz.pixelwastaken.backend.model.roles.Permission;
import xyz.pixelwastaken.backend.model.roles.Ban;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String mcUuid;   // Minecraft UUID
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "player_roles",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    private boolean online;
    private Instant lastSeen;
    private Instant createdAt;

    @OneToOne(mappedBy = "bannedPlayer", cascade = CascadeType.ALL)
    private Ban activeBan;
}
