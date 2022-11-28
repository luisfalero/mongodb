package com.redhat.wom.migration.dao.mongo;

import com.redhat.wom.migration.model.api.response.MigrationEntityResponse;
import reactor.core.publisher.Flux;

public interface MigrationMongoDao {

    Flux<MigrationEntityResponse> findAllMigration();
}
