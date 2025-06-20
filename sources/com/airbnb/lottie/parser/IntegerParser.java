package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class IntegerParser implements ValueParser<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final IntegerParser f17296a = new IntegerParser();

    private IntegerParser() {
    }

    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        return Integer.valueOf(Math.round(JsonUtils.g(jsonReader) * f2));
    }
}
