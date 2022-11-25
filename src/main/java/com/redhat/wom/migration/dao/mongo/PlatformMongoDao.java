package com.redhat.wom.migration.dao.mongo;

import com.redhat.wom.migration.model.api.PlatformEntityResponse;
import reactor.core.publisher.Flux;

public interface PlatformMongoDao {

    Flux<PlatformEntityResponse> findAllPlatform();
}
