package productapp;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Money calculations for a single product sale.
 * Uses BigDecimal so values like 0.1 + 0.2 don't produce rounding noise.
 */
public class ProductCalculations {

   
    public static final BigDecimal VAT_RATE = new BigDecimal("0.15");        
    public static final BigDecimal COMMISSION_RATE = new BigDecimal("0.025"); 

    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING = RoundingMode.HALF_UP;

    private final BigDecimal price;

    public ProductCalculations(BigDecimal price) {
        if (price == null || price.signum() <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        this.price = price.setScale(SCALE, ROUNDING);
    }

    public BigDecimal GetVat() {
        return price.multiply(VAT_RATE).setScale(SCALE, ROUNDING);
    }

    
    public BigDecimal GetCommission() {
        return price.multiply(COMMISSION_RATE).setScale(SCALE, ROUNDING);
    }

    
    public BigDecimal GetTotal() {
        return price.add(GetVat()).add(GetCommission());
    }

    public BigDecimal getPrice() {
        return price;
    }
}