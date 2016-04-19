package com.qoantum.phonebook.orm.repository;

import com.qoantum.phonebook.orm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Role repository
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
