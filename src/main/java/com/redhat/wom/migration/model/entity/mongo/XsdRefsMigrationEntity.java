package com.redhat.wom.migration.model.entity.mongo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class XsdRefsMigrationEntity {

    private String fullName;
    private String projectName;
    private String shortName;
    private String schemaLocation;
    private String schemaString;
}
