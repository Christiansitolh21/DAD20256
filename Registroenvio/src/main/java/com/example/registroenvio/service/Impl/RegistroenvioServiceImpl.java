package com.example.registroenvio.service.Impl;

import com.example.registroenvio.entity.RegistroDetalle;
import com.example.registroenvio.entity.Registroenvio;
import com.example.registroenvio.feign.ClienteFeign;
import com.example.registroenvio.feign.VehiculoFeign;
import com.example.registroenvio.repository.RegistroenvioRepository;
import com.example.registroenvio.service.RegistroenvioService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroenvioServiceImpl implements RegistroenvioService {
    @Autowired
    private RegistroenvioRepository registroenvioRepository;
    @Autowired
    private VehiculoFeign vehiculoFeign;
    @Autowired
    private ClienteFeign clienteFeign;

    @Override
    public List<Registroenvio> listar() {
        return registroenvioRepository.findAll();
    }

    @Override
    public Registroenvio guardar(Registroenvio registroenvio) {
        return registroenvioRepository.save(registroenvio);
    }

    @Override
    public Optional<Registroenvio> buscarPorId(Integer id) {
        Optional<Registroenvio> registroenvio = registroenvioRepository.findById(id);
        if (registroenvio.isPresent()) {
            registroenvio.get().setClienteDto(clienteFeign.getById(registroenvio.get().getClienteId()).getBody());

            registroenvio.get().getDetalles().forEach(registroDetalle -> {
                registroDetalle.setVehiculoDto(vehiculoFeign.getById(registroDetalle.getVehiculoId()).getBody());
            });
        }
        return registroenvio;
    }

    @Override
    public Registroenvio actualizar(Registroenvio registroenvio) {
            return registroenvioRepository.save(registroenvio);
    }

    @Override
    public void eliminar(Integer id) {
        registroenvioRepository.deleteById(id);
    }
}
