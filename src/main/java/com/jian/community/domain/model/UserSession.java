package com.jian.community.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserSession {

    private String id;

    private Long userId;

    private LocalDateTime lastAccessedAt;

    private LocalDateTime expiresAt;

    public static UserSession of(
            String sessionId,
            Long userId,
            LocalDateTime lastAccessedAt,
            LocalDateTime expiresAt
    ) {
        return new UserSession(sessionId, userId, lastAccessedAt, expiresAt);
    }

    public void extendSession(LocalDateTime lastAccessedAt, Duration duration) {
        this.lastAccessedAt = lastAccessedAt;
        this.expiresAt = lastAccessedAt.plus(duration);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiresAt);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSession that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
