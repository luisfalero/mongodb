package com.redhat.wom.migration.dao.mongo.impl;

import com.redhat.wom.migration.dao.mongo.MigrationMongoDao;
import com.redhat.wom.migration.model.api.response.MigrationEntityResponse;
import com.redhat.wom.migration.repository.mongo.PlatformMongoRepository;
import com.redhat.wom.migration.util.CommonsContants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Slf4j
@Component
@AllArgsConstructor
public class MigrationMongoDaoImpl implements MigrationMongoDao {

    private final PlatformMongoRepository repository;

    @Override
    public Flux<MigrationEntityResponse> findAllMigration() {
        return null;
    }
}
