package com.redhat.wom.migration.model.entity.mongo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExportMigrationEntity {

    private String version;
    private List<ProjectListMigrationEntity> projectList;
}
