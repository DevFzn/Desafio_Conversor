/**
 * Converter application for Alura Challenge #2 - G5 ONE
 * @version 0.1
 * @author DevFzn
 * @email devfzn@proton.me
 */
package cl.conversor.app;

/**
 * Currency converter class
 */
public class Conversor {

    /**
     * @param args Optional, to choose the version of the program to run
     * If first argument is "TUI" runs TUI application,
     * if number of arguments is 3 runs CLI (expect arguments CURRENCY CURRENCY AMOUNT in addition),
     * if no arguments are provided runs GUI application.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("TUI")) {
                cl.conversor.vista.tui.ConversorTui.main(null);
            } else if(args.length == 3) {
                cl.conversor.vista.cli.ConversorCli.main(args);
            } else {
                cl.conversor.vista.cli.ConversorCli.ayuda();;
            }
        } else {
            cl.conversor.vista.gui.ConversorGui.main(null);
        }
    }
}