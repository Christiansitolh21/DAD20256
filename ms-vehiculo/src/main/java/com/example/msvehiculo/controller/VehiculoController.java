package com.example.msvehiculo.controller;

import com.example.msvehiculo.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.msvehiculo.service.VehiculoService;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;
    @GetMapping
    public ResponseEntity<List<Vehiculo>> list(){
        return ResponseEntity.ok().body(vehiculoService.listar());
    }
    @PostMapping
    public ResponseEntity<Vehiculo> save(@RequestBody Vehiculo vehiculo){
        return ResponseEntity.ok(vehiculoService.guardar(vehiculo));
    }
    @PutMapping
    public ResponseEntity<Vehiculo> update(@RequestBody Vehiculo vehiculo){
        return ResponseEntity.ok(vehiculoService.actualizar(vehiculo));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(vehiculoService.ListarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Vehiculo>> delete(@PathVariable(required = true) Integer id) {
        vehiculoService.eliminarPorId(id);
        return ResponseEntity.ok(vehiculoService.listar());
    }

}
