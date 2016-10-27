package org.spring.cassandra.example.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.data.cassandra.repository.support.CassandraRepositoryFactory;
import org.springframework.data.cassandra.repository.support.CassandraRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import java.io.Serializable;

/**
 * Created by bfitouri on 27/10/16.
 */

public class CustomRepositoryFactoryBean<R extends TypedIdCassandraRepository<T, I>, T,
        I extends Serializable> extends CassandraRepositoryFactoryBean<R, T, I> {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    protected RepositoryFactorySupport createRepositoryFactory() {
        return new BaseRepositoryFactory(cassandraTemplate);
    }

    private static class BaseRepositoryFactory<T, I extends Serializable>
            extends CassandraRepositoryFactory {

        private final CassandraOperations cassandraOperations;

        public BaseRepositoryFactory(CassandraOperations cassandraOperations) {
            super(cassandraOperations);
            this.cassandraOperations = cassandraOperations;
        }

        @Override
        protected Object getTargetRepository(RepositoryInformation repositoryInformation) {
            CassandraEntityInformation entityInformation = this.getEntityInformation(repositoryInformation.getDomainType());
            return new CustomRepositoryImpl<>(entityInformation, cassandraOperations);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return CustomRepositoryImpl.class;
        }
    }
}