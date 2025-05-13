package pe.edu.upeu.sysventas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.modelo.Cliente;
import pe.edu.upeu.sysventas.repositorio.ClienteRepository;

import java.util.List;

@Service
public class ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    // Create
    public Cliente guardarEntidad(Cliente to) {
        return clienteRepository.save(to);
    }

    // Report
    public List<Cliente> listarEntidad() {
        return clienteRepository.findAll();
    }

    // Update
    public Cliente actualizarEntidad(Cliente to) {
        return clienteRepository.save(to);
    }

    // Delete
    public void eliminarRegEntidad(Long id) {
        clienteRepository.deleteById(id);
    }

    // Buscar por ID
    public Cliente buscarEntidad(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
