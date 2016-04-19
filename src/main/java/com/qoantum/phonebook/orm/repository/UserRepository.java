package com.qoantum.phonebook.orm.repository;

import com.qoantum.phonebook.orm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
