package cl.conversor.vista.cli;

import java.util.Scanner;

/**
 * Main class for <b>CLI</b> converter application 
 */
public class ConversorCli {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LimpiarConsola.clear();
        System.out.println(MenuPrincipal.saludo);

        int input = 1;
        while (input != 0) {
            System.out.println(MenuPrincipal.menu_opcs());
            System.out.print("Ingresa una opción\n --> ");
            input = Integer.valueOf(entrada.nextShort());
            LimpiarConsola.clear();
        }
        System.out.println("Finalizando conversor");
        entrada.close();
        System.exit(0);
    }

}
