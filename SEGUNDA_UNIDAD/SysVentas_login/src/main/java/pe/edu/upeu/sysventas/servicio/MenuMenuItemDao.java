package pe.edu.upeu.sysventas.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.dto.MenuMenuItemTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

    @Service
    public class MenuMenuItemDao implements MenuMenuItemDaoI{
        @Override
        public List<MenuMenuItemTO> listaAccesos(String perfil, Properties
                idioma) {
            List<MenuMenuItemTO> lista = new ArrayList<>();
            lista.add(new MenuMenuItemTO(idioma.getProperty("menu.nombre.archivo"), "", "mifile"));
            lista.add(new MenuMenuItemTO(idioma.getProperty("menu.nombre.archivo"), "Salir", "misalir"));
            lista.add(new MenuMenuItemTO("Edit", "Cortar", "micut"));
            lista.add(new MenuMenuItemTO("Edit", "copiar", "micopy"));
            lista.add(new MenuMenuItemTO("Edit", "pegar", "mipaste"));
            lista.add(new MenuMenuItemTO("Edit", idioma.getProperty("menuitem.nombre.postulante"), "miselectall"));
            lista.add(new MenuMenuItemTO("Producto", "Reg. Producto", "miregproduct"));
            lista.add(new MenuMenuItemTO("Producto", "Ver2", "miver2"));
            lista.add(new MenuMenuItemTO("Producto", "Auto Complete", "miautcomp"));
            lista.add(new MenuMenuItemTO("Venta", "Reg. Venta", "miventa"));
            lista.add(new MenuMenuItemTO("Principal", "Cliente", "cliente"));
            lista.add(new MenuMenuItemTO("Principal", "Rep. Venta", "repventa"));
            lista.add(new MenuMenuItemTO("Principal", "Reg. Venta", "regventa"));
            List<MenuMenuItemTO> accesoReal = new ArrayList<>();
            switch (perfil) {
                case "Administrador":
                    accesoReal.add(lista.get(0));
                    accesoReal.add(lista.get(1));
                    accesoReal.add(lista.get(2));
                    accesoReal.add(lista.get(3));
                    accesoReal.add(lista.get(4));
                    accesoReal.add(lista.get(5));
                    accesoReal.add(lista.get(6));
                    break;
                case "Root":
                    accesoReal = lista;
                    break;
                case "Reporte":
                    accesoReal.add(lista.get(0));
                    accesoReal.add(lista.get(5));
                    accesoReal.add(lista.get(6));
                    break;
                default:
                    throw new AssertionError();
            }
            return accesoReal;
        }
    }

