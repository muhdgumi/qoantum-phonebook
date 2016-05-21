package com.qoantum.phonebook.orm.repository;

import com.qoantum.phonebook.orm.entity.GroupMember;
import com.qoantum.phonebook.orm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Group member repository
 */
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

    Collection<GroupMember> findByUser(final User user);
}
