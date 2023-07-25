package cl.conversor.vista.cli;

import java.util.List;

/**
 *  Class to create title, opts/menus Strings
 */
public class MenuPrincipal {
    public String titulo; 
    public static final List<String> menu = List.of(
             "Salir",
             "juan",
             "roberto",
             "pancracio",
             "zerafin" + Color.RESET.code()
         );
    private static final String color_baner = Color.YELLOW.code();
    private static final String color_titulo = Color.CYAN.code();
    private static final String color_opcs = Color.GREEN.code();
    private static final String color_ind = Color.PURPLE.code();
    private static final String color_rst = Color.RESET.code();
    private static final String color_err = Color.RED.code();
    private static final String mensaje_error = "¡Debes ingresar un número válido!";   
    public MenuPrincipal(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return String   Banner String
     */
    public String banner() {
        int largo = this.titulo.length()+8;
        StringBuilder titulo = new StringBuilder();
        titulo.append(color_baner);
        titulo.append("=".repeat(largo));
        titulo.append("\n -- "+ color_titulo + this.titulo 
                      + color_baner + " -- " + color_rst);
        return titulo.toString();
    }
    
    /**
     * @param msj       Application Title
     * @return String   Banner String
     */
    public String banner(String mensaje) {
        int largo = this.titulo.length()+8;
        StringBuilder titulo = new StringBuilder();
        titulo.append(color_baner);
        titulo.append("=".repeat(largo));
        titulo.append("\n -- "+ color_titulo + mensaje 
                      + color_baner + " -- " + color_rst);
        return titulo.toString();
    }

    /**
     * @return formatted String that represents menus options
     */
    public String menu_opcs() {
        int largo = this.titulo.length()+8;
        int pad = 4;
        StringBuilder opciones = new StringBuilder();
        opciones.append(color_baner + "=".repeat(largo)
                        + "\n" + color_rst);
        opciones.append(color_opcs + "  Menu de opciones:\n\n");
        for (int i = 0; i < menu.size(); i++) {
            if (i!=0) {
                opciones.append(" ".repeat(pad) + color_ind + i +") "
                                + color_opcs + menu.get(i) + "\n");
            }
        }
        opciones.append(" ".repeat(pad) + color_err + "0) " + color_rst
                        + color_opcs + menu.get(0) + "\n" + color_rst);
        opciones.append("\n" + color_baner + "=".repeat(largo) + color_rst);
        return opciones.toString();
    }
    
    /**
     * @return String user input error message
     */
    public String error_in() {
        return new StringBuilder(color_err + mensaje_error + color_rst).toString();
    }
}
