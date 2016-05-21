package com.qoantum.phonebook.orm.repository;

import com.qoantum.phonebook.orm.entity.User;
import com.qoantum.phonebook.orm.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * User role repository.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Collection<UserRole> findByUser(final User user);
}
