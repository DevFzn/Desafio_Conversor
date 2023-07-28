package cl.conversor.vista.tui;

import java.util.Scanner;

import cl.conversor.moneda.Moneda;

/**
 * Main class for <b>TUI</b> converter application 
 */
public class ConversorTui {

    private static Scanner entrada = new Scanner(System.in);
    private static MenuPrincipal menu; 

    /**
     * @param orig (Moneda) origin
     * @param dest (Moneda) target
     * @param monto Double amount
     * @return Double currency conversion 
     */
    public static Double conversion(Moneda orig, Moneda dest, Double monto) {
        return orig.convert(dest, monto);
        
    }
    
    /*
     * Prints result of currency conversion
     * @param orig Currency (Moneda) origin
     * @param dest Currency (Moneda) to convert
     * @param titulo String banner
     */
    public static void conversion(Moneda orig, Moneda dest, String titulo) {
        System.out.println(menu.baner("Convertir " + titulo));
        System.out.println(menu.baner("\n"));
        LimpiarConsola.clear();
        System.out.println(menu.baner(titulo));
        System.out.print("\nIngresa el valor a convertir\n --> ");
        Double monto = Double.valueOf(entrada.next());
        LimpiarConsola.clear();
        String datos_conversion = menu.resultado( titulo,
                                                  orig.toString(),
                                                  orig.symbol(),
                                                  monto.toString(),
                                                  dest.toString(),
                                                  dest.symbol(),
                                                  orig.convert(dest, monto).toString());
        System.out.println(datos_conversion);
    }
    
    /**
     * Main <b>TUI</b> application 
     * @param args unused
     */
    public static void main(String[] args) {
        LimpiarConsola.clear();
        menu = new MenuPrincipal("Bienvenido al conversor de monedas");
        System.out.println(menu.baner());

        int input = 1;
        while (input != 0) {
            System.out.println(menu.menu_opcs());
            System.out.print("Ingresa una opción\n --> ");
            try {
                input = Integer.valueOf(entrada.next());
                LimpiarConsola.clear();
                switch (input) {
                    case 0:
                            System.out.println(menu.baner(" = Aplicación Finalizada ="));
                        break;
                    case 1:
                            conversion(Moneda.CLP, Moneda.USD, menu.menu.get(input));
                        break;
                    case 2:
                            conversion(Moneda.CLP, Moneda.EUR, menu.menu.get(input));
                        break;
                    case 3:
                            conversion(Moneda.CLP, Moneda.GBP, menu.menu.get(input));
                        break;
                    case 4:
                            conversion(Moneda.CLP, Moneda.JPY, menu.menu.get(input));
                        break;
                    case 5:
                            conversion(Moneda.CLP, Moneda.KRW, menu.menu.get(input));
                        break;
                    case 6:
                            conversion(Moneda.USD, Moneda.CLP, menu.menu.get(input));
                        break;
                    case 7:
                            conversion(Moneda.EUR, Moneda.CLP, menu.menu.get(input));
                        break;
                    case 8:
                            conversion(Moneda.GBP, Moneda.CLP, menu.menu.get(input));
                        break;
                    case 9:
                            conversion(Moneda.JPY, Moneda.CLP, menu.menu.get(input));
                        break;
                    case 10:
                            conversion(Moneda.KRW, Moneda.CLP, menu.menu.get(input));
                        break;
                    default:
                        throw new IndexOutOfBoundsException();
                }
            } catch (Exception e) {
                LimpiarConsola.clear();
                //e.printStackTrace();
                System.out.println(menu.baner(menu.error_in()));
            }
        }
        entrada.close();
        System.exit(0);
    }
}
