package com.jian.community.infrastructure.persistence.jpa;

import com.jian.community.domain.model.PostLike;
import com.jian.community.domain.repository.crud.PostLikeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostLikeJpaRepository extends PostLikeRepository, JpaRepository<PostLike, Long> {

    @Override
    PostLike save(PostLike postLike);

    @Override
    List<PostLike> findByIdPostId(Long postId);

    @Override
    Optional<PostLike> findByIdPostIdAndIdUserId(Long postId, Long userId);

    @Override
    void deleteByIdPostIdAndIdUserId(Long postId, Long userId);
}
