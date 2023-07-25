package cl.conversor.vista.cli;

/**
 * Interface to clear OS terminal screen, on case of IDE Console
 * it just prints 80 new lines.
 */
public interface LimpiarConsola {

    static void clear() {
        System.out.println("\n".repeat(80));
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //System.out.println("\n".repeat(100));
        }
    }

}