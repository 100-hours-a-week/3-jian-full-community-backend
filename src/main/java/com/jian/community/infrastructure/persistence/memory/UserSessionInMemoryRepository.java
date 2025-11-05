package com.jian.community.infrastructure.persistence.memory;

import com.jian.community.domain.model.UserSession;
import com.jian.community.domain.repository.crud.UserSessionRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Primary
public class UserSessionInMemoryRepository implements UserSessionRepository {

    private final Map<String, UserSession> store = new ConcurrentHashMap<>();

    @Override
    public UserSession save(UserSession userSession) {
        store.put(userSession.getId(), userSession);
        return userSession;
    }

    @Override
    public Optional<UserSession> findById(String id) {
        UserSession userSession = store.get(id);
        return Optional.ofNullable(userSession);
    }

    @Override
    public void deleteById(String id) {
        store.remove(id);
    }
}
