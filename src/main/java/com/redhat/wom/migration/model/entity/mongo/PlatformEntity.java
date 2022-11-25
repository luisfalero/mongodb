package com.redhat.wom.migration.model.entity.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(value="platform")
public class PlatformEntity {

    @Id
    private String id;
    private String name;
    private String description;
}
