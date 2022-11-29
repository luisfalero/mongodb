package com.redhat.wom.migration.model.api.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServicesEntityResponse {

    private List<ServiceEntityResponse> service;
}
