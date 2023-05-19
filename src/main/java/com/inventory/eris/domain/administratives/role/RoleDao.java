package com.inventory.eris.domain.administratives.role;

import java.util.Optional;

public interface RoleDao {
    Role saveRole(Role role);

    Optional<Role> findByRoleType(String role_type);
}
