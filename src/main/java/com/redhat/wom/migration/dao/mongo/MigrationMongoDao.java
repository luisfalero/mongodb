package com.redhat.wom.migration.dao.mongo;

import com.redhat.wom.migration.model.api.response.MigrationEntityResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MigrationMongoDao {

    Mono<MigrationEntityResponse> findById(String id);
    Flux<MigrationEntityResponse> findAllMigration();
}
