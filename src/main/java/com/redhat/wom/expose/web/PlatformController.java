package com.redhat.wom.expose.web;


import com.redhat.wom.migration.dao.mongo.PlatformMongoDao;
import com.redhat.wom.migration.model.api.request.PlatformEntityRequest;
import com.redhat.wom.migration.model.api.response.PlatformEntityResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("platform")
@AllArgsConstructor
@ControllerAdvice
public class PlatformController {

    private final PlatformMongoDao entity;

    @PostMapping(value = "/save")
    public Mono<PlatformEntityResponse> savePlatform(@Valid @RequestBody PlatformEntityRequest entityRequest) {
        return entity.savePlatform(entityRequest);
    }

    @GetMapping(value = "/all")
    public Flux<PlatformEntityResponse> getFinancialEntities() {
        return entity.findAllPlatform();
    }
}
