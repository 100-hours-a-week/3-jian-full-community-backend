package com.jian.community.domain.repository.query;

import com.jian.community.domain.dto.CursorPage;
import com.jian.community.domain.model.Comment;

import java.time.LocalDateTime;

public interface CommentQueryRepository {

    CursorPage<Comment> findAllByPostIdOrderByCreatedAtDesc(Long postId, LocalDateTime cursor, int pageSize);
}
