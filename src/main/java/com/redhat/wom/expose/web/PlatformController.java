package com.redhat.wom.expose.web;


import com.redhat.wom.migration.dao.mongo.PlatformMongoDao;
import com.redhat.wom.migration.model.api.PlatformEntityResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("platform")
@AllArgsConstructor
public class PlatformController {

    private final PlatformMongoDao entity;

    @GetMapping(value = "/all")
    public Flux<PlatformEntityResponse> getFinancialEntities() {
        return entity.findAllPlatform();
    }
}
