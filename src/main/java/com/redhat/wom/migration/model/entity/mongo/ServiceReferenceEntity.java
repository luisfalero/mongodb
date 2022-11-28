package com.redhat.wom.migration.model.entity.mongo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceReferenceEntity {

    private String projectName;
    private String fullName;
    private String shortName;
    private boolean external;
    private String serviceType;
    private Integer count;
    
}
