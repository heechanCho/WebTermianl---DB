package org.webterminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.webterminal.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String username);
}
