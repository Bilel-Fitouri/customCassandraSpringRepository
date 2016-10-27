package org.spring.cassandra.example.custom;

/**
 * Created by bfitouri on 26/10/16.
 */
import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable> extends TypedIdCassandraRepository<T, ID> {

    T findOne(ID var1);
}
