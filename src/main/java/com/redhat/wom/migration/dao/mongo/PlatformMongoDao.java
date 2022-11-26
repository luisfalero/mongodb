package com.redhat.wom.migration.dao.mongo;

import com.redhat.wom.migration.model.api.PlatformEntityRequest;
import com.redhat.wom.migration.model.api.PlatformEntityResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlatformMongoDao {

    Mono<PlatformEntityResponse> savePlatform(PlatformEntityRequest entityRequest);
    Flux<PlatformEntityResponse> findAllPlatform();
}
