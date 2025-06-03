package pe.edu.upeu.sysventas.dto;

import lombok.Data;

@Data
public class MenuMenuItemTO {
    public String menunombre, menuitemnombre, nombreObj;
    public MenuMenuItemTO(String menunombre, String menuitemnombre, String nombreObj) {
        this.menunombre = menunombre;
        this.menuitemnombre = menuitemnombre;
        this.nombreObj = nombreObj;
    }
    public MenuMenuItemTO() {
    }
}