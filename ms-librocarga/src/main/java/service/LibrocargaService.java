package service;

import entity.Librocarga;

import java.util.List;
import java.util.Optional;

public interface LibrocargaService {
    public List<Librocarga> listar();

    public Librocarga guardar(Librocarga libro_carga);

    public Optional<Librocarga> buscarPorId(Integer id);

    public Librocarga actualizar(Librocarga libro_carga);

    public void eliminar(Integer id);
}
