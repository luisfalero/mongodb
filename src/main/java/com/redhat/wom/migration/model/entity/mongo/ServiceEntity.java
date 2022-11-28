package com.redhat.wom.migration.model.entity.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(value="service")
public class ServiceEntity {

    @Id
    private String id;
    private String name;
    
}
