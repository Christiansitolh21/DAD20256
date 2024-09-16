package com.example.msvehiculo.service.Impl;

import com.example.msvehiculo.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.msvehiculo.repository.VehiculoRepository;
import com.example.msvehiculo.service.VehiculoService;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> listar() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo actualizar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Optional<Vehiculo> ListarPorId(Integer id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        vehiculoRepository.deleteById(id);
    }
}
