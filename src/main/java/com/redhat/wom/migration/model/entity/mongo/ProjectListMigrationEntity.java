package com.redhat.wom.migration.model.entity.mongo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectListMigrationEntity {

    private String projectName;
    private Object proxyServices;
    private Object businessServices;
}
