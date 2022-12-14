package com.redhat.wom.expose.web;


import com.redhat.wom.migration.dao.mongo.MigrationMongoDao;
import com.redhat.wom.migration.model.api.response.MigrationEntityResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("migration")
@AllArgsConstructor
@ControllerAdvice
public class MigrationController {

    private final MigrationMongoDao entity;

    @GetMapping(value = "/find/{id}")
    public Mono<MigrationEntityResponse> findById(@PathVariable("id") String id) {
        return entity.findById(id);
    }
}
