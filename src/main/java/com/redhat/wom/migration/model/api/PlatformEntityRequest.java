package com.redhat.wom.migration.model.api;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlatformEntityRequest {

    private String name;
    private String description;
}
