package cl.conversor.vista.tui;

import java.util.List;

/**
 *  Class to create formatted Strings
 */
public class MenuPrincipal {
    public String titulo; 
    public final List<String> menu = List.of(
             "Salir",
             "CLP a USD",
             "CLP a EUR",
             "CLP a GBP",
             "CLP a JPY",
             "CLP a KRW",
             "USD a CLP",
             "EUR a CLP",
             "GBP a CLP",
             "JPY a CLP",
             "KRW a CLP"
         );
    private static final String color_baner = Color.YELLOW.code();
    private static final String color_titulo = Color.CYAN.code();
    private static final String color_opcs = Color.GREEN.code();
    private static final String color_ind = Color.PURPLE.code();
    private static final String color_rst = Color.RESET.code();
    private static final String color_err = Color.RED.code();
    private static final String color_conv = Color.BLACK_BKG.code()+Color.CYAN.code();
    private static final String mensaje_error = "¡Debes ingresar un número válido!";   
    public MenuPrincipal(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return String   Banner String
     */
    public String baner() {
        int largo = this.titulo.length()+8;
        StringBuilder titulo = new StringBuilder();
        titulo.append(color_baner);
        titulo.append("=".repeat(largo));
        titulo.append("\n -- "+ color_titulo + this.titulo 
                      + color_baner + " -- " + color_rst);
        return titulo.toString();
    }
    
    /**
     * @param mensaje   Application Title
     * @return String   Banner String
     */
    public String baner(String mensaje) {
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
        int pad = 5;
        StringBuilder opciones = new StringBuilder();
        opciones.append(color_baner + "=".repeat(largo)
                        + "\n" + color_rst);
        opciones.append(color_opcs + "  Menu de opciones:\n\n");
        for (int i = 0; i < menu.size(); i++) {
            if (i!=0) {
                opciones.append(
                        color_ind + String.format("%1$"+(pad+2)+"s", i )
                        +") " + color_opcs + menu.get(i) + "\n");
            }
        }
        opciones.append(" ".repeat(pad+1) + color_err + "0) " + color_rst
                        + color_opcs + menu.get(0) + "\n" + color_rst);
        opciones.append("\n" + color_baner + "=".repeat(largo) + color_rst);
        return opciones.toString();
    }
    
    /**
     * @return formatted String that represents result of currency conversion
     */
    public String resultado(String...datos) {
        StringBuilder conversion = new StringBuilder();
        conversion.append(baner("Conversion "+datos[0])+"\n\n"+color_conv);
        conversion.append(datos[1] +" "+ datos[2] +" "+datos[3]+" .-\n");
        conversion.append(datos[4] +" "+ datos[5] +" "+ datos[6]+" .-\n"+ color_rst);
        return conversion.toString();
        
    }
    
    /**
     * @return String user input error message
     */
    public String error_in() {
        return new StringBuilder(color_err + mensaje_error + color_rst).toString();
    }
}
