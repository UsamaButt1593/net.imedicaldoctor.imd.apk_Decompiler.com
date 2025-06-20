package org.threeten.bp.format;

import java.math.BigDecimal;
import java.math.BigInteger;

public final /* synthetic */ class a {
    public static /* synthetic */ BigDecimal a(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}
