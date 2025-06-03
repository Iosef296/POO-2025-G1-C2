package pe.edu.upeu.sysventas.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.sysventas.dto.MenuMenuItemTO;
import pe.edu.upeu.sysventas.servicio.MenuMenuItemDao;
import pe.edu.upeu.sysventas.servicio.MenuMenuItemDaoI;
import pe.edu.upeu.sysventas.util.UtilsX;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.prefs.Preferences;

@Controller
public class GUIMainFX {
    @Autowired
    private ApplicationContext context;
    Preferences userPrefs = Preferences.userRoot();
    UtilsX util = new UtilsX();
    Properties myresources = new Properties();
    MenuMenuItemDaoI mmiDao;
    @FXML
    private TabPane tabPaneFx;
    List<MenuMenuItemTO> lista;
    @FXML
    private BorderPane bp;
    @FXML
    private MenuBar menuBarFx;
    @FXML
    public void initialize() {
        myresources = util.detectLanguage(userPrefs.get("IDIOMAX", "es"));
        mmiDao = new MenuMenuItemDao();
        lista = mmiDao.listaAccesos("Root", myresources);
        int[] mmi = contarMenuMunuItem(lista);
        Menu[] menu = new Menu[mmi[0]];
        MenuItem[] menuItem = new MenuItem[mmi[1]];
        menuBarFx = new MenuBar();
        MenuItemListener d = new MenuItemListener();
        SampleMenuListener m = new SampleMenuListener();
        String menuN = "";
        int menui = 0, menuitem = 0;
        char conti = 'N';
        for (MenuMenuItemTO mmix : lista) {
            if (!mmix.menunombre.equals(menuN)) {
                menu[menui] = new Menu(mmix.menunombre);
                menu[menui].setId("m" + mmix.nombreObj);
                menu[menui].setOnShowing(m::menuSelected);
                if (!mmix.menuitemnombre.equals("")) {
                    menuItem[menuitem] = new MenuItem(mmix.menuitemnombre);
                    menuItem[menuitem].setId("mi" + mmix.nombreObj);
                    menuItem[menuitem].setOnAction(d::handle);
                    menu[menui].getItems().add(menuItem[menuitem]);
                    menuitem++;
                }
                menuBarFx.getMenus().add(menu[menui]);
                menuN = mmix.menunombre;
                conti = 'N';
                menui++;
            } else {
                conti = 'S';
            }
            if (!mmix.menuitemnombre.equals("") && mmix.menunombre.equals(menuN) && conti == 'S') {
                menuItem[menuitem] = new MenuItem(mmix.menuitemnombre);
                menuItem[menuitem].setId("mi" + mmix.nombreObj);
                menuItem[menuitem].setOnAction(d::handle);
                menu[menui - 1].getItems().add(menuItem[menuitem]);
                menuitem++;
            }
        }
        // Layout principal
        bp.setTop(menuBarFx);
        bp.setCenter(tabPaneFx);
    }
    class MenuItemListener {
        public void handle(javafx.event.ActionEvent e) {
            if (((MenuItem) e.getSource()).getId().equals("mimiregproduct")) {
                tabPaneFx.getTabs().clear();
                FXMLLoader loader = new
                        FXMLLoader(getClass().getResource("/view/main_producto.fxml"));
                loader.setControllerFactory(context::getBean);
                Parent paneFromFXML;
                try {
                    paneFromFXML = loader.load(); // Cargar el contenido FXML
                    ScrollPane dd= new ScrollPane(paneFromFXML);
                    //mc.setContexto(ctx);
                    Tab clienteTab = new Tab("Reg. Producto",dd );
                    tabPaneFx.getTabs().add(clienteTab);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (((MenuItem) e.getSource()).getId().equals("mimiselectall")) {
                tabPaneFx.getTabs().clear();
                // Añade la lógica para "mimiselectall"
            }
        }
    }
    class SampleMenuListener {
        public void menuSelected(javafx.event.Event e) {
            if (((Menu) e.getSource()).getId().equals("mmiver1")) {
                System.out.println("llego help");
            }
        }
    }

    public int[] contarMenuMunuItem(List<MenuMenuItemTO> data) {
        int menui = 0, menuitem = 0;
        String menuN = "";
        for (MenuMenuItemTO mmi : data) {
            if (!mmi.menunombre.equals(menuN)) {
                menuN = mmi.menunombre;
                menui++;
            }
            if (!mmi.menuitemnombre.equals("")) {
                menuitem++;
            }
        }
        return new int[]{menui, menuitem};
    }

}
