package cl.conversor.vista.cli;


import cl.conversor.moneda.Moneda;

/**
 * Main class for <b>CLI</b> converter application 
 */
public class ConversorCli {

    /**
     * Main <b>CLI</b> application 
     * @param args String[3] (currency, currency, amount)
     */
    public static void main(String[] args) {
        String origen = "";
        String destino = "";
        Double monto = 0.0;
        try {
            if (Moneda.esMoneda(args[0].toUpperCase())) {
                origen = args[0].toUpperCase();
            }
            if (Moneda.esMoneda(args[1].toUpperCase())) {
                destino = args[1].toUpperCase();
            }
            monto = Double.valueOf(args[2]);
            String resultado;
            resultado = Moneda.monedaString(conversion(Moneda.valueOf(origen), Moneda.valueOf(destino), monto));
            StringBuilder convert_repr = new StringBuilder();
            convert_repr.append("\nConversion de "+ origen +" "+ Moneda.valueOf(origen).symbol());
            convert_repr.append(" "+ Moneda.monedaString(monto) +" a "+destino+" ");
            convert_repr.append(Moneda.valueOf(destino).symbol()+" "+resultado+"\n");
            System.out.println(convert_repr);
        } catch (Exception e){
              ayuda();
        }
        System.exit(0);
    }

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
     * Help and usage menu 
     */
    public static void ayuda() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("\n\nConversor de Monedas\n\n");
        resultado.append("USO\n    java -jar Conversor.jar <opcs>\n\n");
        resultado.append("OPCIONES\n    GUI Mode - java -jar Conversor\n");
        resultado.append("    TUI Mode - java -jar Conversor TUI\n");
        resultado.append("    CLI Mode - java -jar Conversor <MONEDA_ORIGEN> <MONEDA_DESTINO> <MONTO>\n");
        resultado.append("           ej. java -jar Conversor CLP JPY 1000\n\nMONEDAS\n   ");
        for (Moneda moneda : Moneda.values()) {
            resultado.append(" "+moneda.name()+" ");
        }
        resultado.append("");
        System.out.println(resultado.toString());
    }

}