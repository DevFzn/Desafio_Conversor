package cl.conversor.vista.cli;

import java.util.Scanner;

/**
 * Main class for <b>CLI</b> converter application 
 */
public class ConversorCli {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LimpiarConsola.clear();
        MenuPrincipal menu = new MenuPrincipal("Bienvenido al conversor de monedas");
        System.out.println(menu.banner());

        int input = 1;
        while (input != 0) {
            System.out.println(menu.menu_opcs());
            System.out.print("Ingresa una opción\n --> ");
            try {
                input = Integer.valueOf(entrada.next());
                LimpiarConsola.clear();
            } catch (Exception e) {
                LimpiarConsola.clear();
                System.out.println(menu.banner(menu.error_in()));
            }
        }
        System.out.println(" = Aplicación Finalizada =");
        entrada.close();
        System.exit(0);
    }

}
