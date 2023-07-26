/**
 * Currency converter for Alura Challenge - G5 ONE 
 * @author DevFzn
 */
package cl.conversor.app;

/**
 * 
 */
public class Conversor {

    /**
     * @param args pending
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String string : args) {
                System.out.println(string);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cl.conversor.vista.tui.ConversorTui.main(args);
    }

}
