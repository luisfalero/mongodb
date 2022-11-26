package com.redhat.wom.migration.model.api.request;

import lombok.*;
import javax.validation.constraints.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlatformEntityRequest {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 4, max = 15)
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 4, max = 30)
    private String description;
}
