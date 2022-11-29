package com.redhat.wom.migration.dao.mongo;

import com.redhat.wom.migration.model.api.response.ServicesEntityResponse;
import reactor.core.publisher.Mono;

public interface ServiceMongoDao {

    Mono<ServicesEntityResponse> findById(String id);
}
