package com.ChallengueForoHub.ChallengueForoHub.controller;

import com.ChallengueForoHub.ChallengueForoHub.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopic> registrarTopic(@RequestBody @Valid DatosRegistroTopic datosRegistroTopic,
                                                              UriComponentsBuilder uriComponentsBuilder){
        Topic topic = topicRepository.save(new Topic(datosRegistroTopic));
        DatosRespuestaTopic datosRespuestaTopic = new DatosRespuestaTopic(topic.getId(), topic.getTitulo(), topic.getMensaje(),
                topic.getFechaCreacion(), topic.getStatus(), topic.getAutor(), topic.getCurso());
        URI url = uriComponentsBuilder.path("/topic/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopic);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopic>> listadoTopic(Pageable paginacion){
        return ResponseEntity.ok(topicRepository.findAll(paginacion).map(DatosListadoTopic::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopic> retordaDatosMedico(@PathVariable Long id){
        Topic topic = topicRepository.getReferenceById(id);
        var datosTopic = new DatosRespuestaTopic(topic.getId(), topic.getTitulo(), topic.getMensaje(),
                topic.getFechaCreacion(), topic.getStatus(), topic.getAutor(), topic.getCurso());
        return ResponseEntity.ok(datosTopic);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopic(@RequestBody @Valid DatosActualizarTopic datosActualizarTopic, @PathVariable Long id){
        Topic topic = topicRepository.getReferenceById(id);
        topic.actualizarDatos(datosActualizarTopic);
        return ResponseEntity.ok(new DatosRespuestaTopic(topic.getId(), topic.getTitulo(), topic.getMensaje(), topic.getFechaCreacion(),
                topic.getStatus(), topic.getAutor(), topic.getCurso()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopic(@PathVariable Long id){
        Topic topic = topicRepository.getReferenceById(id);
        topicRepository.delete(topic);
        return ResponseEntity.noContent().build();
    }


}
