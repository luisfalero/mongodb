package com.redhat.wom.migration.dao.mongo.impl;

import com.redhat.wom.migration.dao.mongo.PlatformMongoDao;
import com.redhat.wom.migration.model.api.PlatformEntityResponse;
import com.redhat.wom.migration.repository.mongo.PlatformMongoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@AllArgsConstructor
public class PlatformMongoDaoImpl implements PlatformMongoDao {

    private final PlatformMongoRepository repository;

    @Override
    public Flux<PlatformEntityResponse> findAllPlatform() {
        Flux<PlatformEntityResponse> response = repository
                .findAll()
                .flatMap(element -> {
                    PlatformEntityResponse entity = new PlatformEntityResponse();
                    BeanUtils.copyProperties(element, entity);
                    entity.setId(element.getId());
                    return Mono.just(entity);
                });
        response.subscribe(element -> log.info(element.toString()));
        return response;
    }
}
