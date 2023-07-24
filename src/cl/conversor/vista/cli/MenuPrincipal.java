package cl.conversor.vista.cli;

import java.util.List;

/**
 *  Class to create title, opts/menus Strings
 */
public abstract class MenuPrincipal {
    public static final String mensaje = "Bienvenido al Conversor-CLI"; 
    public static final String saludo = banner(mensaje);
    public static final List<String> menu = List.of(
             "Salir",
             "juan",
             "roberto",
             "pancracio",
             "zerafin"
         );
    
    /**
     * @param msj       Application Title
     * @return String   Title String
     */
    public static String banner(String msj) {
        int largo = msj.length()+8;
        StringBuilder titulo = new StringBuilder();
        titulo.append("=".repeat(largo));
        titulo.append("\n -- "+msj+" -- ");
        return titulo.toString();
    }
    
    /**
     * @return formatted String that represents menus options
     */
    public static String menu_opcs() {
        int largo = mensaje.length()+8;
        int pad = 4;
        StringBuilder opciones = new StringBuilder();
        opciones.append("=".repeat(largo)+"\n");
        opciones.append("  Menu de opciones:\n\n");
        for (int i = 0; i < menu.size(); i++) {
            if (i!=0) {
                opciones.append(" ".repeat(pad)+i+") "+menu.get(i)+"\n");
            }
        }
        opciones.append(" ".repeat(pad)+"0) "+menu.get(0)+"\n");
        opciones.append("\n"+"=".repeat(largo));
        return opciones.toString();
    }
}
