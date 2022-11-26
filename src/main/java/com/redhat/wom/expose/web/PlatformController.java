package com.redhat.wom.expose.web;


import com.redhat.wom.migration.dao.mongo.PlatformMongoDao;
import com.redhat.wom.migration.model.api.PlatformEntityRequest;
import com.redhat.wom.migration.model.api.PlatformEntityResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("platform")
@AllArgsConstructor
public class PlatformController {

    private final PlatformMongoDao entity;

    @PostMapping(value = "/save")
    public Mono<PlatformEntityResponse> savePlatform(@RequestBody PlatformEntityRequest entityRequest) {
        return entity.savePlatform(entityRequest);
    }

    @GetMapping(value = "/all")
    public Flux<PlatformEntityResponse> getFinancialEntities() {
        return entity.findAllPlatform();
    }
}
