package com.jian.community.domain.model;

import com.jian.community.domain.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity(name = "tb_post")
public class Post extends MinimalEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Convert(converter = StringListConverter.class)
    @Column(name = "post_image_urls", nullable = false)
    private List<String> postImageUrls = new ArrayList<>();

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = Boolean.FALSE;

    public static Post of(User user, String title, String content, List<String> postImageUrls) {
        Post post = new Post();
        post.user = user;
        post.title = title;
        post.content = content;
        post.postImageUrls = postImageUrls;
        return post;
    }

    public void update(String title, String content, List<String> postImageUrls) {
        this.title = title;
        this.content = content;
        this.postImageUrls = postImageUrls;
    }

    public boolean isWrittenBy(User writer){
        return user != null && user.equals(writer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
