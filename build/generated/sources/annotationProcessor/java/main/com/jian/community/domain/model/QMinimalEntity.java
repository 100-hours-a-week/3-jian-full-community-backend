package com.jian.community.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMinimalEntity is a Querydsl query type for MinimalEntity
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QMinimalEntity extends EntityPathBase<MinimalEntity> {

    private static final long serialVersionUID = 200390287L;

    public static final QMinimalEntity minimalEntity = new QMinimalEntity("minimalEntity");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QMinimalEntity(String variable) {
        super(MinimalEntity.class, forVariable(variable));
    }

    public QMinimalEntity(Path<? extends MinimalEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMinimalEntity(PathMetadata metadata) {
        super(MinimalEntity.class, metadata);
    }

}

