package com.ChallengueForoHub.ChallengueForoHub.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private String status;
    private String autor;
    private String curso;

    public Topic(DatosRegistroTopic datosRegistroTopic){
        this.status = datosRegistroTopic.status();
        this.titulo = datosRegistroTopic.titulo();
        this.mensaje = datosRegistroTopic.mensaje();
        this.fechaCreacion = datosRegistroTopic.fechaCreacion();
        this.autor = datosRegistroTopic.autor();
        this.curso = datosRegistroTopic.curso();
    }

    public void actualizarDatos(DatosActualizarTopic datosActualizarTopic) {
        this.titulo = datosActualizarTopic.titulo();
        this.mensaje = datosActualizarTopic.mensaje();
        this.status = datosActualizarTopic.status();
        this.curso = datosActualizarTopic.curso();

    }

}
