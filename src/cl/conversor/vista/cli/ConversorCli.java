package cl.conversor.vista.cli;


import cl.conversor.moneda.Moneda;

/**
 * Main class for <b>CLI</b> converter application 
 */
public class ConversorCli {

    /**
     * @param orig Origin currency
     * @param dest Target currency
     * @param monto Amount of `orig` currency to convert into `dest` currency
     * @return Double currency conversion
     */
    public static Double conversion(Moneda orig, Moneda dest, Double monto) {
        return orig.convert(dest, monto);
    }

    /**
     * Check if `value` is part of enum Moneda
     * @param value String currency
     * @return true if value is an enum Moneda, otherwise returns false
     */
    public static boolean esMoneda(String value) {
        for (Moneda e : Moneda.class.getEnumConstants()) {
            if(e.name().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Help and usage menu 
     */
    public static void ayuda() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("\n\nConversor de Monedas\n\n");
        resultado.append("USO\n    java -jar Conversor.jar <opcs>\n\n");
        resultado.append("OPCIONES\n    GUI Mode - > java -jar Conversor\n");
        resultado.append("    TUI Mode - > java -jar Conversor TUI\n");
        resultado.append("    CLI Mode - > java -jar Conversor <MONEDA_ORIGEN> <MONEDA_DESTINO> <MONTO>\n");
        resultado.append("             ej. java -jar Conversor CLP JPY 1000\n\n");
        System.out.println(resultado.toString());
    }

    /**
     * Main <b>CLI</b> application 
     * @param args String[3] (currency, currency, amount)
     */
    public static void main(String[] args) {
        String origen = "";
        String destino = "";
        Double monto = 0.0;
        try {
            if (esMoneda(args[0].toUpperCase())) {
                origen = args[0].toUpperCase();
            }
            if (esMoneda(args[1].toUpperCase())) {
                destino = args[1].toUpperCase();
            }
            monto = Double.valueOf(args[2]);
            String resultado = conversion(Moneda.valueOf(origen), Moneda.valueOf(destino), monto).toString();
            StringBuilder convert_repr = new StringBuilder();
            convert_repr.append("\nConversion de "+origen+" "+Moneda.valueOf(origen).symbol());
            convert_repr.append(" "+monto+" a "+destino+" "+Moneda.valueOf(destino).symbol());
            convert_repr.append(" "+resultado+"\n");
            System.out.println(convert_repr);
        } catch (Exception e){
              ayuda();
        }
        System.exit(0);
    }
}
