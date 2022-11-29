package com.redhat.wom.migration.model.entity.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(value="migration")
public class MigrationEntity {

    @Id
    private String id;
    private String name;
    private boolean migration;
    private ExportMigrationEntity export;
}
