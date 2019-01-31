package com.ehayes.springit2.SpringitRepository;

import com.ehayes.springit2.Springitmodel.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
