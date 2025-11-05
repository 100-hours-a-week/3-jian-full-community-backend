package com.jian.community.application.service;

import com.jian.community.application.mapper.CursorPageMapper;
import com.jian.community.application.mapper.PostDtoMapper;
import com.jian.community.domain.dto.CursorPage;
import com.jian.community.domain.model.*;
import com.jian.community.domain.repository.crud.*;
import com.jian.community.domain.repository.query.PostQueryRepository;
import com.jian.community.presentation.dto.CommentResponse;
import com.jian.community.presentation.dto.CursorResponse;
import com.jian.community.presentation.dto.PostDetailResponse;
import com.jian.community.presentation.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostQueryService {

    private static final int POST_PAGE_SIZE = 10;

    private final PostRepository postRepository;
    private final PostQueryRepository postQueryRepository;
    private final PostLikeRepository postLikeRepository;
    private final PostViewRepository postViewRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostViewService postViewService;
    private final CommentService commentService;

    public CursorResponse<PostResponse> getPosts(LocalDateTime cursor) {
        CursorPage<Post> page = postQueryRepository.findAllOrderByCreatedAtDesc(cursor, POST_PAGE_SIZE);

        return CursorPageMapper.toCursorResponse(page, post -> {
            User writer = userRepository.findByIdOrThrow(post.getUser().getId());
            List<PostLike> likes = postLikeRepository.findByIdPostId(post.getId());
            List<Comment> comments = commentRepository.findByPostId(post.getId());
            PostView view = postViewRepository.findByPostIdOrThrow(post.getId());

            return PostDtoMapper.toPostResponse(post, writer, likes.size(), comments.size(), view.getCount());
        });
    }

    public PostDetailResponse getPostDetail(Long postId) {
        Post post = postRepository.findByIdOrThrow(postId);
        User writer = userRepository.findByIdOrThrow(post.getUser().getId());
        List<PostLike> likes = postLikeRepository.findByIdPostId(postId);
        CursorResponse<CommentResponse> commentPreview = commentService.getRecentComments(postId);
        PostView view = postViewService.increaseAndGet(postId); // FIXME: 이벤트 기반으로 바꾸기

        return PostDtoMapper.toPostDetailResponse(
                post, writer,
                likes.size(), commentPreview.getItems().size(), view.getCount(),
                commentPreview
        );
    }
}
