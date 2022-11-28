package com.redhat.wom.migration.model.entity.mongo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WsdlMigrationEntity {

    private String name;
    private String wsdlString;
    private String wsdlRef;
    private Object xsdRefs;
}
