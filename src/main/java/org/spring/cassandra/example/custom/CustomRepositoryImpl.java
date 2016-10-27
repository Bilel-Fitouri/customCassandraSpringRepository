package org.spring.cassandra.example.custom;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.query.CassandraEntityInformation;
import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;

import java.io.Serializable;

/**
 * Created by bfitouri on 26/10/16.
 */
public class CustomRepositoryImpl <T, ID extends Serializable> extends SimpleCassandraRepository<T, ID> implements CustomRepository<T, ID> {

    protected CassandraOperations operations;
    protected CassandraEntityInformation<T, ID> entityInformation;

    public CustomRepositoryImpl(CassandraEntityInformation<T, ID> metadata, CassandraOperations operations){
        super(metadata, operations);
        this.operations = operations;
    }

    @Override
    public T findOne(ID id){
        System.out.println("this is an overrided method");
        return super.findOne(id);
    }

    //here goes the new methods


}

