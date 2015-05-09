package com.java.spring.web.flow.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 289907236L;

    public static final QAccount account = new QAccount("account");

    public final QModel _super = new QModel(this);

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath password = createString("password");

    public final EnumPath<com.java.spring.web.flow.enums.Role> role = createEnum("role", com.java.spring.web.flow.enums.Role.class);

    public final EnumPath<Account.StatusAccount> statusAccount = createEnum("statusAccount", Account.StatusAccount.class);

    public final StringPath userName = createString("userName");

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    public QAccount(Path<? extends Account> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata<?> metadata) {
        super(Account.class, metadata);
    }

}

