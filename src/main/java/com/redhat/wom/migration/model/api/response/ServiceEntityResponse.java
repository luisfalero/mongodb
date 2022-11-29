package com.redhat.wom.migration.model.api.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceEntityResponse {

    private String projectName;
    private String version;
}
