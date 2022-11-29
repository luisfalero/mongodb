package com.redhat.wom.migration.dao.mongo.impl;

import com.redhat.wom.migration.dao.mongo.ServiceMongoDao;
import com.redhat.wom.migration.exception.ServiceGenericException;
import com.redhat.wom.migration.model.api.response.ServiceEntityResponse;
import com.redhat.wom.migration.model.api.response.ServicesEntityResponse;
import com.redhat.wom.migration.repository.mongo.MigrationMongoRepository;
import com.redhat.wom.migration.repository.mongo.ServiceMongoRepository;
import com.redhat.wom.migration.util.CommonsContants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class ServiceMongoDaoImpl implements ServiceMongoDao {

    private final ServiceMongoRepository repository;
    private final MigrationMongoRepository migrationMongoRepository;

    @Override
    public Mono<ServicesEntityResponse> findById(String id) {
        Mono<ServicesEntityResponse> response = migrationMongoRepository
                .findById(id)
                .flatMap(element -> {
                    List<ServiceEntityResponse> service = new ArrayList<>();
                    ServicesEntityResponse entity = new ServicesEntityResponse();

                    element.getExport().getProjectList().stream().forEach(data -> {
                        ServiceEntityResponse serviceEntityResponse = new ServiceEntityResponse();
                        serviceEntityResponse.setProjectName(data.getProjectName());
                        serviceEntityResponse.setVersion(element.getExport().getVersion());
                        service.add(serviceEntityResponse);
                    });

                    entity.setService(service);


                    return  Mono.just(entity);
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
}
