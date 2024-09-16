package com.example.registroenvio.controller;

import com.example.registroenvio.entity.Registroenvio;
import com.example.registroenvio.service.RegistroenvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registroenvio")
public class RegistroenvioController {
    @Autowired
    private RegistroenvioService registroenvioService;

    @GetMapping
    public ResponseEntity<List<Registroenvio>> listar(){
        return ResponseEntity.ok(registroenvioService.listar());
    }

    @PostMapping
    public ResponseEntity<Registroenvio> guardar(@RequestBody Registroenvio registroenvio){
        return ResponseEntity.ok(registroenvioService.guardar(registroenvio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registroenvio> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(registroenvioService.buscarPorId(id).get());
    }

    @PutMapping
    public ResponseEntity<Registroenvio> actualizar(@RequestBody Registroenvio registroenvio){
        return ResponseEntity.ok(registroenvioService.actualizar(registroenvio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Registroenvio>> eliminar(@PathVariable(required = true) Integer id){
        registroenvioService.eliminar(id);
        return ResponseEntity.ok(registroenvioService.listar());
    }
}
