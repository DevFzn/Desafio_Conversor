/**
 * Currency converter for Alura Challenge - G5 ONE 
 * @author DevFzn
 */
package cl.conversor.app;

/**
 * Currency converter class
 */
public class Conversor {

    /**
     * @param args Optional, to choose the version of the program to run
     * If first argument it's "TUI" runs TUI application,
     * if length of arguments it's 3 runs CLI (expect arguments CURRENCY CURRENCY AMOUNT in addition),
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
            System.out.println("Conversor GUI");
            //cl.conversor.vista.jp.main(null);
        }
    }
}