package com.redhat.wom.migration.model.entity.mongo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProxyServiceMigrationEntity {

    private WsdlMigrationEntity wsdl;
    private ServiceReferenceEntity businessServiceReferences;
    private ServiceReferenceEntity otherServiceReferences;
    private String name;
}
