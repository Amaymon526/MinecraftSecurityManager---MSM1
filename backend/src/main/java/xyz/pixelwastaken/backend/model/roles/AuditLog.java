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
@Table(name = "audit_logs")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Player actor;

    private String action;   // "KICK", "DELETE_USER"
    private String target;   // target uuid/username
    private String details;
    private Instant timestamp;
}
