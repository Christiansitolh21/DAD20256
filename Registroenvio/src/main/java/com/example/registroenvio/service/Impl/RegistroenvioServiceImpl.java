package com.example.registroenvio.service.Impl;

import com.example.registroenvio.entity.Registroenvio;
import com.example.registroenvio.repository.RegistroenvioRepository;
import com.example.registroenvio.service.RegistroenvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroenvioServiceImpl implements RegistroenvioService {
    @Autowired
    private RegistroenvioRepository registroenvioRepository;

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
        return registroenvioRepository.findById(id);
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
