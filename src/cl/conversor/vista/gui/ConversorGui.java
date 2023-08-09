/**
 * Converter application for Alura Challenge #2 - G5 ONE
 */
package cl.conversor.vista.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Main class for <b>GUI</b> converter application
 */
public class ConversorGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private static JMenuBar menuBar;
    private static JMenu menu;
    private static JMenuItem opcion0;
    private static JMenuItem opcion1;
    private static JMenuItem opcion2;

    private ConversorGui() {

        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/logo_green.png"));
            setIconImage(icono.getImage());
        } catch (Exception e) {
            System.out.println("Icono no encontrado");
        }
        setSize(330,100);
        setTitle("Conversor Alura G5 ONE");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        menuPrincipal();
        panel.add(menuBar);
        add(panel);
        opcion0.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        menuBar.getParent(), "Cerrando aplicación",
                        "Conversor finalizado", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        opcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConversorMoneda.main(null);
                dispose();
            }
        });

    }
    
    /**
     * Main menu with conversion choices and exit option
     */
    private static void menuPrincipal() {
        menuBar = new JMenuBar();
        menu = new JMenu("Elige una opción");
        menu.setMnemonic('e');
        opcion0 = new JMenuItem("Salir");
        opcion1 = new JMenuItem("Conversor de Monedas");
        opcion2 = new JMenuItem("Otros (pendiente)");
        opcion0.setMnemonic('s');
        opcion1.setMnemonic('c');
        opcion2.setMnemonic('o');
        opcion2.setEnabled(false);

        menu.add(opcion1);
        menu.add(opcion2);
        menu.add(opcion0);
        menuBar.add(menu);
    }

    /**
     * @param args Not used
     */
    public static void main(String[] args) {
        //System.out.println("Conversor GUI version \u2665");
        SwingUtilities.invokeLater(() -> {
            ConversorGui aplicacion = new ConversorGui();
            aplicacion.setVisible(true);
        });
    }

}
