package cl.conversor.moneda;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Moneda currency representation `NAME (symbol, rate)`  
 */
public enum Moneda {
    USD ("$", new BigDecimal("1")),
    CLP ("$", new BigDecimal("827.786512")),
    EUR ("€", new BigDecimal("0.904528")),
    GBP ("£", new BigDecimal("0.775054")),
    JPY ("¥", new BigDecimal("140.92065996")),
    KRW ("₩", new BigDecimal("1276.580533"));

    private final String symbol;
    private final BigDecimal rate;

    Moneda (String symbol, BigDecimal rate){
        this.symbol = symbol;
        this.rate = rate;
    }
    
    public final String symbol() {
        return this.symbol;
    }
    
    public final BigDecimal rate() {
        return this.rate;
    }
    
    /**
     * Converts to base currency (USD) at self.rate
     * @param monto amount to convert to base currency
     * @return BigDecimal base value
     */
    public final BigDecimal getBase(BigDecimal monto) {
        MathContext mc = new MathContext(7);
        return monto.divide(this.rate(),mc);
    }
    
    /**
     * Converts `monto` to `destino` currency
     * @param destino target conversion Currency 
     * @param monto amount
     * @return Double conversion
     */
    public final Double convert(Moneda destino, Double monto) {
        BigDecimal monto_orig = new BigDecimal(monto);
        monto_orig = getBase(monto_orig);
        return  Double.valueOf((monto_orig.multiply(destino.rate(), new MathContext(7)).toString()));
    }
}
