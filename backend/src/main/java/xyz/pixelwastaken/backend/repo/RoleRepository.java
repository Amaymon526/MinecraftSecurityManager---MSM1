package xyz.pixelwastaken.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.pixelwastaken.backend.model.roles.Role;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
