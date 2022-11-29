package com.redhat.wom.migration.model.api.response;

import com.redhat.wom.migration.model.entity.mongo.ExportMigrationEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MigrationEntityResponse {

    private String id;
    private String name;
    private boolean migration;
    private ExportMigrationEntity export;
}
