package com.ChallengueForoHub.ChallengueForoHub.topic;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopic(@NotBlank
                                 String titulo,
                                 @NotBlank
                                 String mensaje,
                                 @NotBlank
                                 String fechaCreacion,
                                 @NotBlank
                                 String status,
                                 @NotBlank
                                 String autor,
                                 @NotBlank
                                 String curso) {

}
