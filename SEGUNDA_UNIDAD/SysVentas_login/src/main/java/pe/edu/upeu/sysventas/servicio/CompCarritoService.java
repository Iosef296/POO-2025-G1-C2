package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.modelo.CompCarrito;
import pe.edu.upeu.sysventas.repositorio.CompCarritoRepository;

import java.util.List;

@Service
public class CompCarritoService{

    @Autowired
    private CompCarritoRepository compCarritoRepository;

    // Create
    public CompCarrito guardarEntidad(CompCarrito to) {
        return compCarritoRepository.save(to);
    }

    // Report
    public List<CompCarrito> listarEntidad() {
        return compCarritoRepository.findAll();
    }

    // Update
    public CompCarrito actualizarEntidad(CompCarrito to) {
        return compCarritoRepository.save(to);
    }

    // Delete
    public void eliminarRegEntidad(Long id) {
        compCarritoRepository.deleteById(id);
    }

    // Buscar por ID
    public CompCarrito buscarEntidad(Long id) {
        return compCarritoRepository.findById(id).orElse(null);
    }
}
