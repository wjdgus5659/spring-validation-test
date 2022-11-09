package com.matt.spring.validation.repository;

import com.matt.spring.validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 사용자 관련 JPA Repository
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, String> {
}
