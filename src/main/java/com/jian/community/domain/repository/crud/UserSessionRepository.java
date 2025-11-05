package com.jian.community.domain.repository.crud;

import com.jian.community.domain.model.UserSession;

import java.util.Optional;

public interface UserSessionRepository {

    UserSession save(UserSession userSession);

    Optional<UserSession> findById(String id);

    void deleteById(String id);
}
