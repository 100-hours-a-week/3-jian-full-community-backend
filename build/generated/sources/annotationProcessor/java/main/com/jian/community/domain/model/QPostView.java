package com.jian.community.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPostView is a Querydsl query type for PostView
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPostView extends EntityPathBase<PostView> {

    private static final long serialVersionUID = -1010302246L;

    public static final QPostView postView = new QPostView("postView");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public QPostView(String variable) {
        super(PostView.class, forVariable(variable));
    }

    public QPostView(Path<? extends PostView> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostView(PathMetadata metadata) {
        super(PostView.class, metadata);
    }

}

