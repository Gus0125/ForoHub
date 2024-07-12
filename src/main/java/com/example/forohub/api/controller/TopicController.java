package com.example.forohub.api.controller;

import com.example.forohub.api.model.Topic;
import com.example.forohub.api.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        topic.setFechaCreacion(LocalDateTime.now());
        return topicRepository.save(topic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(topic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topicDetails) {
        Topic topic = topicRepository.findById(id).orElseThrow();
        topic.setTitulo(topicDetails.getTitulo());
        topic.setMensaje(topicDetails.getMensaje());
        topic.setStatus(topicDetails.getStatus());
        topic.setFechaCreacion(LocalDateTime.now());
        Topic updatedTopic = topicRepository.save(topic);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTopic(@PathVariable Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow();
        topicRepository.delete(topic);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
