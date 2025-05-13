package pe.edu.upeu.sysventas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.upeu.sysventas.modelo.Marca;
import pe.edu.upeu.sysventas.repositorio.MarcaRepository;

import java.util.List;

@SpringBootApplication
public class SysVentasApplication implements CommandLineRunner {

	@Autowired
	private MarcaRepository marcaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SysVentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		List<Marca> listaMarcas = marcaRepository.findAll();
		for (Marca marca : listaMarcas) {
			System.out.println(marca.getNombre());
		}
	}

}
