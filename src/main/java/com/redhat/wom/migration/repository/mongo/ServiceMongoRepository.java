package com.redhat.wom.migration.repository.mongo;

import com.redhat.wom.migration.model.entity.mongo.ServiceEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceMongoRepository extends ReactiveMongoRepository<ServiceEntity, String> {

}
