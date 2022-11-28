package com.redhat.wom.migration.model.api.response;

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
    private String description;
}
