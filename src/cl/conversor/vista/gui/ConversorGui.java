/**
 * 
 */
package cl.conversor.vista.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Main class for <b>GUI</b> converter application
 */
public class ConversorGui extends JFrame {

    private static final long serialVersionUID = 1L;
        private JMenuBar menuBar;
        private JMenu menu;
        private JMenuItem opcion0;
        private JMenuItem opcion1;
        private JMenuItem opcion2;
        private JMenuItem opcion3;
        private JMenuItem opcion4;
        private JMenuItem opcion5;
        private JMenuItem opcion6;
        private JMenuItem opcion7;
        private JMenuItem opcion8;
        private JMenuItem opcion9;
        private JMenuItem opcion10;

    public ConversorGui() {
        try {
            Image icono;
            icono = javax.imageio.ImageIO.read(new java.io.File("media/logo_green.png"));
            setIconImage(icono);
        } catch (IOException e) {
            System.out.println("Icono no encontrado");
            e.printStackTrace();
        }
        setSize(600,400);
        setTitle("Conversor Alura G5 ONE");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        menuConversion();
        panel.add(menuBar);
        add(panel);
        opcion0.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "Finalizando conversor");
                System.exit(0);
            }
            
        });
    }
    
    public void menuConversion() {
        menuBar = new JMenuBar();
        menu = new JMenu("Elige una opción");
        menu.setMnemonic('e');
        
        opcion0 = new JMenuItem("Salir");
        opcion1 = new JMenuItem("Convertir CLP a USD");
        opcion2 = new JMenuItem("Convertir CLP a EUR");
        opcion3 = new JMenuItem("Convertir CLP a GBP");
        opcion4 = new JMenuItem("Convertir CLP a JPY");
        opcion5 = new JMenuItem("Convertir CLP a KRW");
        opcion6 = new JMenuItem("Convertir USD a CLP");
        opcion7 = new JMenuItem("Convertir EUR a CLP");
        opcion8 = new JMenuItem("Convertir GBP a CLP");
        opcion9 = new JMenuItem("Convertir JPY a CLP");
        opcion10 = new JMenuItem("Convertir KRW a CLP");
        
        opcion0.setMnemonic('s');
        opcion1.setMnemonic('1');
        opcion2.setMnemonic('2');
        opcion3.setMnemonic('3');
        opcion4.setMnemonic('4');
        opcion5.setMnemonic('5');
        opcion6.setMnemonic('6');
        opcion7.setMnemonic('7');
        opcion8.setMnemonic('8');
        opcion9.setMnemonic('9');
        opcion10.setMnemonic('0');
        
        menu.add(opcion1);
        menu.add(opcion2);
        menu.add(opcion3);
        menu.add(opcion4);
        menu.add(opcion5);
        menu.add(opcion6);
        menu.add(opcion7);
        menu.add(opcion8);
        menu.add(opcion9);
        menu.add(opcion10);
        menu.add(opcion0);
        menuBar.add(menu);
    }
    /**
     * @param args Not used
     */
    public static void main(String[] args) {
        System.out.println("Conversor GUI version \u2665");
        SwingUtilities.invokeLater(() -> {
            ConversorGui aplicacion = new ConversorGui();
            aplicacion.setVisible(true);
        });
    }

}
