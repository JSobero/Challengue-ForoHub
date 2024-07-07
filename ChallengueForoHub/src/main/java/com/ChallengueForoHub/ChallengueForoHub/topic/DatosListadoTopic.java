package com.ChallengueForoHub.ChallengueForoHub.topic;

public record DatosListadoTopic(Long id,
                                String titulo,
                                String mensaje,
                                String fechaCreacion,
                                String status,
                                String autor,
                                String curso) {
    public DatosListadoTopic(Topic topic){
        this(topic.getId(), topic.getTitulo(), topic.getMensaje(),
                topic.getFechaCreacion(), topic.getStatus(), topic.getAutor(), topic.getCurso());
    }
}
