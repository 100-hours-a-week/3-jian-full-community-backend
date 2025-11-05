package com.jian.community.application.service;

import com.jian.community.domain.model.PostView;
import com.jian.community.domain.repository.crud.PostViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostViewService {

    private final PostViewRepository postViewRepository;

    @Transactional
    public PostView increaseAndGet(Long postId) {
        postViewRepository.increaseCount(postId);
        return postViewRepository.findByPostIdOrThrow(postId);
    }
}
