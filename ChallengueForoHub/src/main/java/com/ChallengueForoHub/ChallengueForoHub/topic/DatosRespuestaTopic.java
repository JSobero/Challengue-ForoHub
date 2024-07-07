package com.ChallengueForoHub.ChallengueForoHub.topic;

public record DatosRespuestaTopic(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        String status,
        String autor,
        String curso
) {
    public DatosRespuestaTopic(Topic topic) {
        this(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getFechaCreacion(), topic.getStatus(),
                topic.getAutor(), topic.getCurso());
    }
}
