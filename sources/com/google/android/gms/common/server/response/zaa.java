package com.google.android.gms.common.server.response;

import androidx.annotation.Nullable;
import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

final class zaa implements zai<Integer> {
    zaa() {
    }

    @Nullable
    public final /* synthetic */ Object a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        return Integer.valueOf(fastParser.n(bufferedReader));
    }
}
