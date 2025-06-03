package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.sysventas.modelo.VentCarrito;
import pe.edu.upeu.sysventas.repositorio.VentCarritoRepository;

import java.util.List;

@Service
public class VentCarritoService{

    @Autowired
    private VentCarritoRepository ventCarritoRepository;

    // Create
    public VentCarrito guardarEntidad(VentCarrito to) {
        return ventCarritoRepository.save(to);
    }

    // Report
    public List<VentCarrito> listarEntidad() {
        return ventCarritoRepository.findAll();
    }

    // Update
    public VentCarrito actualizarEntidad(VentCarrito to) {
        return ventCarritoRepository.save(to);
    }

    // Delete
    public void eliminarRegEntidad(Long id) {
        ventCarritoRepository.deleteById(id);
    }

    // Buscar por ID
    public VentCarrito buscarEntidad(Long id) {
        return ventCarritoRepository.findById(id).orElse(null);
    }
    public List<VentCarrito> listaCarritoCliente(String dni) {
        return ventCarritoRepository.listaCarritoCliente(dni);
    }
    @Transactional
    public void deleteCarAll(String dniruc) {
        ventCarritoRepository.deleteByDniruc(dniruc);
    }
}
