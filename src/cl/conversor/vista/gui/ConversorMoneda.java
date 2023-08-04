package cl.conversor.vista.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import cl.conversor.moneda.Moneda;

/**
 * Currency converter class
 */
public class ConversorMoneda extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final String titulo = "Conversión de Moneda";
    private static JMenuBar menuBarOpcs;
    private static JMenu menuOpcs;
    private static JMenuItem opcion0;
    private static JMenuItem opcion1;
    private static JMenuItem opcion2;
    private static JMenuItem opcion3;
    private static JMenuItem opcion4;
    private static JMenuItem opcion5;
    private static JMenuItem opcion6;
    private static JMenuItem opcion7;
    private static JMenuItem opcion8;
    private static JMenuItem opcion9;
    private static JMenuItem opcion10;
    
    
    /** Creates a JMenuBar with currency converter options
     * @return JMenuBar
     */
    public static Component menuConversion() {
        menuBarOpcs = new JMenuBar();
        menuOpcs = new JMenu("Opciones de conversión");
        menuOpcs.setMnemonic('o');
        
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
        
        menuOpcs.add(opcion1);
        menuOpcs.add(opcion2);
        menuOpcs.add(opcion3);
        menuOpcs.add(opcion4);
        menuOpcs.add(opcion5);
        menuOpcs.add(opcion6);
        menuOpcs.add(opcion7);
        menuOpcs.add(opcion8);
        menuOpcs.add(opcion9);
        menuOpcs.add(opcion10);
        menuOpcs.add(opcion0);
        menuBarOpcs.add(menuOpcs);
        
        opcion0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        menuOpcs, "Finalizando conversor",
                        "Cerrando aplicación", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        opcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.CLP, Moneda.USD);
            }
        });
        
        opcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.CLP, Moneda.EUR);
            }
        });
        
        opcion3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.CLP, Moneda.GBP);
            }
        });
        
        opcion4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.CLP, Moneda.JPY);
            }
        });
        
        opcion5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.CLP, Moneda.KRW);
            }
        });
        
        opcion6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.USD, Moneda.CLP);
            }
        });
        
        opcion7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.EUR, Moneda.CLP);
            }
        });
        
        opcion8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.GBP, Moneda.CLP);
            }
        });
        
        opcion9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.JPY, Moneda.CLP);
            }
        });
        
        opcion10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultadoConversion(Moneda.KRW, Moneda.CLP);
            }
        });
        
        return menuBarOpcs;
    }
    
    /** 
     * Handles user input for amount to convert. Validates, converts and return value.
     * @param orig String origin currency
     * @param dest String target currency
     * @return Double amount to convert
     */
    public static Double montoConversion(String orig, String dest) {
        Double montoIn = 0D;
        String resp; 
        while (montoIn == 0D) {
            try {
                resp = JOptionPane.showInputDialog(
                        menuBarOpcs, "Ingresa el monto a convertir",
                        "Conversion "+orig+" a "+dest,
                        JOptionPane.QUESTION_MESSAGE);
                if (resp == null) {
                    return null;
                } else {
                    return montoIn = Double.valueOf(resp);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        menuBarOpcs, "Debes ingresar un número válido",
                        titulo, JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return null;
    }
    
    /**
     * Shows result of currency conversion
     * @param orig Moneda origin currency
     * @param dest Moneda target currency
     */
    public static void resultadoConversion(Moneda orig, Moneda dest) {
        Double monto = montoConversion(orig.name(), dest.name());
        if (monto != null) {
            StringBuilder resultado = new StringBuilder();
            resultado.append(orig.symbol()+" "+Moneda.monedaString(monto)+" "+orig.name()+" equivalen a ");
            resultado.append(dest.symbol()+" "+Moneda.monedaString(orig.convert(dest, monto)));
            resultado.append(" "+dest.name());
            JOptionPane.showMessageDialog(menuBarOpcs, resultado.toString(), titulo, JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
