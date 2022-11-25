package com.redhat.wom.migration.repository.mongo;

import com.redhat.wom.migration.model.entity.mongo.PlatformEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformMongoRepository extends ReactiveMongoRepository<PlatformEntity, String> {
}
