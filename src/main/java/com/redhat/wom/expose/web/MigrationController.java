package com.redhat.wom.expose.web;


import com.redhat.wom.migration.dao.mongo.MigrationMongoDao;
import com.redhat.wom.migration.model.api.response.MigrationEntityResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Validated
@RestController
@RequestMapping("migration")
@AllArgsConstructor
@ControllerAdvice
public class MigrationController {

    private final MigrationMongoDao entity;


    @GetMapping(value = "/all")
    public Flux<MigrationEntityResponse> findAllMigration() {
        return entity.findAllMigration();
    }
}
