package com.ChallengueForoHub.ChallengueForoHub.topic;

public record DatosActualizarTopic(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String status,
        String autor,
        String curso
) {
}
