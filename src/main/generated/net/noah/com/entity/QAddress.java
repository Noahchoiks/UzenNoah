package net.noah.com.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAddress extends EntityPathBase<Address> {

    private static final long serialVersionUID = 2012535179L;

    public static final QAddress address = new QAddress("address");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath address3 = createString("address3");

    public final StringPath addressDetail = createString("addressDetail");

    public final NumberPath<Integer> addressNo = createNumber("addressNo", Integer.class);

    public final NumberPath<Integer> zipCodeNo1 = createNumber("zipCodeNo1", Integer.class);

    public final NumberPath<Integer> zipCodeNo2 = createNumber("zipCodeNo2", Integer.class);

    public QAddress(String variable) {
        super(Address.class, forVariable(variable));
    }

    public QAddress(Path<? extends Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata<?> metadata) {
        super(Address.class, metadata);
    }

}

