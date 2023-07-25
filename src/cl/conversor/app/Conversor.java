/**
 * Currency conversor for Alura Challenge - G5 ONE 
 * @author DevFzn 
 */
package cl.conversor.app;


/**
 * 
 */
public class Conversor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (String string : args) {
            System.out.println(string);
        }
        cl.conversor.vista.cli.ConversorCli.main(args);
    }

}
