package com.google.android.gms.common.server.response;

import androidx.annotation.Nullable;
import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

interface zai<O> {
    @Nullable
    O a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException;
}
