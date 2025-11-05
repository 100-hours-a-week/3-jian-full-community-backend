package com.jian.community.infrastructure.persistence.jpa;

import com.jian.community.domain.model.User;
import com.jian.community.domain.repository.crud.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends UserRepository, JpaRepository<User, Long> {

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long userId);

    @Override
    Optional<User> findByEmail(String email);

    @Override
    void deleteById(Long userId);

    @Override
    boolean existsByEmail(String email);

    @Override
    boolean existsByNickname(String nickname);
}
