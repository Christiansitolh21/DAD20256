package service.Impl;

import entity.Librocarga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LibrocargaRepository;
import service.LibrocargaService;

import java.util.List;
import java.util.Optional;

@Service
public class LibrocargaServiceImpl implements LibrocargaService {
    @Autowired
    private LibrocargaRepository Libro_cargaRepository;

    @Override
    public List<Librocarga> listar() {
        return Libro_cargaRepository.findAll();
    }

    @Override
    public Librocarga guardar(Librocarga libro_carga) {
        return Libro_cargaRepository.save(libro_carga);
    }

    @Override
    public Optional<Librocarga> buscarPorId(Integer id) {
        return Libro_cargaRepository.findById(id);
    }

    @Override
    public Librocarga actualizar(Librocarga libro_carga) {
        return Libro_cargaRepository.save(libro_carga);
    }


    @Override
    public void eliminar(Integer id) {
        Libro_cargaRepository.deleteById(id);
    }
}
