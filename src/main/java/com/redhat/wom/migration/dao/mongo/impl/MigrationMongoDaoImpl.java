package com.redhat.wom.migration.dao.mongo.impl;

import com.redhat.wom.migration.dao.mongo.MigrationMongoDao;
import com.redhat.wom.migration.exception.ServiceGenericException;
import com.redhat.wom.migration.model.api.response.MigrationEntityResponse;
import com.redhat.wom.migration.model.entity.mongo.ExportMigrationEntity;
import com.redhat.wom.migration.model.entity.mongo.MigrationEntity;
import com.redhat.wom.migration.repository.mongo.MigrationMongoRepository;
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
public class MigrationMongoDaoImpl implements MigrationMongoDao {

    private final MigrationMongoRepository repository;

    @Override
    public Mono<MigrationEntityResponse> findById(String id) {
        Mono<MigrationEntityResponse> response = repository
                .findById(id)
                .flatMap(element -> {
                    MigrationEntityResponse entity = new MigrationEntityResponse();
                    entity.setId(id);
                    entity.setName(element.getName());
                    entity.setMigration(element.isMigration());

                    ExportMigrationEntity exportMigrationEntity = new ExportMigrationEntity();
                    exportMigrationEntity.setVersion(element.getExport().getVersion());
                    exportMigrationEntity.setProjectList(element.getExport().getProjectList());
                    exportMigrationEntity.setProjectList(element.getExport().getProjectList());
                    entity.setExport(exportMigrationEntity);

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
    public Flux<MigrationEntityResponse> findAllMigration() {
        return null;
    }

}
