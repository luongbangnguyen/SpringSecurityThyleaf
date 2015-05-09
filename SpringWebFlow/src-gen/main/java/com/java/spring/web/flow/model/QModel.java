package com.java.spring.web.flow.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QModel is a Querydsl query type for Model
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QModel extends EntityPathBase<Model> {

    private static final long serialVersionUID = 753640672L;

    public static final QModel model = new QModel("model");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QModel(String variable) {
        super(Model.class, forVariable(variable));
    }

    public QModel(Path<? extends Model> path) {
        super(path.getType(), path.getMetadata());
    }

    public QModel(PathMetadata<?> metadata) {
        super(Model.class, metadata);
    }

}

