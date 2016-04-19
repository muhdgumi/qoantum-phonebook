package com.qoantum.phonebook.orm.repository;

import com.qoantum.phonebook.orm.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Group repository
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
}
