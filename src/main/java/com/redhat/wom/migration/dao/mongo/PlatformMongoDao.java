package com.redhat.wom.migration.dao.mongo;

import com.redhat.wom.migration.model.api.request.PlatformEntityRequest;
import com.redhat.wom.migration.model.api.response.PlatformEntityResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlatformMongoDao {

    Mono<PlatformEntityResponse> savePlatform(PlatformEntityRequest entityRequest);
    Flux<PlatformEntityResponse> findAllPlatform();

}
