package com.jian.community.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity(name = "tb_post_view")
public class PostView {

    @Id
    @Column(name = "post_id", nullable = false, updatable = false)
    private Long postId;

    @Column(name = "count", nullable = false)
    private Integer count = 0;

    public static PostView from(Long postId) {
        PostView postView = new PostView();
        postView.postId = postId;
        return postView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostView that)) return false;
        return Objects.equals(postId, that.postId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId);
    }
}
