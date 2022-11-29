package com.redhat.wom.expose.web;


import com.redhat.wom.migration.dao.mongo.ServiceMongoDao;
import com.redhat.wom.migration.model.api.response.ServicesEntityResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("service")
@AllArgsConstructor
@ControllerAdvice
public class ServiceController {

    private final ServiceMongoDao entity;

    @GetMapping(value = "/find/{id}")
    public Mono<ServicesEntityResponse> findById(@PathVariable("id") String id) {
        return entity.findById(id);
    }
}
