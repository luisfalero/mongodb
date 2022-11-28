package com.redhat.wom.migration.dao.mongo.impl;

import com.redhat.wom.migration.dao.mongo.PlatformMongoDao;
import com.redhat.wom.migration.exception.ServiceGenericException;
import com.redhat.wom.migration.model.api.request.PlatformEntityRequest;
import com.redhat.wom.migration.model.api.response.PlatformEntityResponse;
import com.redhat.wom.migration.model.entity.mongo.PlatformEntity;
import com.redhat.wom.migration.repository.mongo.PlatformMongoRepository;
import com.redhat.wom.migration.util.CommonsContants;
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
    public Mono<PlatformEntityResponse> savePlatform(PlatformEntityRequest entityRequest) {
        PlatformEntity platformEntity = new PlatformEntity();
        BeanUtils.copyProperties(entityRequest, platformEntity);
        Mono<PlatformEntityResponse> response = repository
                .save(platformEntity)
                .flatMap(element -> {
                    PlatformEntityResponse entity = new PlatformEntityResponse();
                    BeanUtils.copyProperties(element, entity);
                    return Mono.just(entity);
                })
                .onErrorResume(element -> Mono.error(
                        new ServiceGenericException(
                                CommonsContants.TL00001,
                                CommonsContants.TL00001_LITERAL,
                                element.getMessage()
                        )
                ));
        return response;
    }

    @Override
    public Flux<PlatformEntityResponse> findAllPlatform() {
        Flux<PlatformEntityResponse> response = repository
                .findAll()
                .flatMap(element -> {
                    PlatformEntityResponse entity = new PlatformEntityResponse();
                    BeanUtils.copyProperties(element, entity);
                    return Mono.just(entity);
                })
                .onErrorResume(element -> Mono.error(
                        new ServiceGenericException(
                                CommonsContants.TL00001,
                                CommonsContants.TL00001_LITERAL,
                                element.getMessage()
                        )
                ));
        response.subscribe(element -> {});
        return response;
    }
}
