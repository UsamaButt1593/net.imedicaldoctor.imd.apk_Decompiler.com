package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

interface ValueParser<V> {
    V a(JsonReader jsonReader, float f2) throws IOException;
}
