package com.google.android.gms.common.server.response;

import androidx.annotation.Nullable;
import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

final class zah implements zai<BigDecimal> {
    zah() {
    }

    @Nullable
    public final /* synthetic */ Object a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        return fastParser.u(bufferedReader);
    }
}
