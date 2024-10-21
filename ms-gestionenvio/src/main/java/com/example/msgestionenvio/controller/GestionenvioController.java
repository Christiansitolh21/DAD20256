package com.example.msgestionenvio.controller;

import com.example.msgestionenvio.entity.Gestionenvio;
import com.example.msgestionenvio.service.GestionenvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestionenvio")
public class GestionenvioController {
    @Autowired
    private GestionenvioService gestionenvioService;

    @GetMapping
    public ResponseEntity<List<Gestionenvio>> listar(){
        return ResponseEntity.ok(gestionenvioService.listar());
    }

    @PostMapping
    public ResponseEntity<Gestionenvio> guardar(@RequestBody Gestionenvio gestionenvio){
        return ResponseEntity.ok(gestionenvioService.guardar(gestionenvio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gestionenvio> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(gestionenvioService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gestionenvio> actualizar(@PathVariable Integer id, @RequestBody Gestionenvio gestionenvio){
        return ResponseEntity.ok(gestionenvioService.actualizar(gestionenvio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Gestionenvio>> eliminar(@PathVariable(required = true) Integer id){
        gestionenvioService.eliminar(id);
        return ResponseEntity.ok(gestionenvioService.listar());
    }

}
