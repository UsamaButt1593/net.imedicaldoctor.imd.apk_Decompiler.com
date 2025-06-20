package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class FloatParser implements ValueParser<Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final FloatParser f17286a = new FloatParser();

    private FloatParser() {
    }

    /* renamed from: b */
    public Float a(JsonReader jsonReader, float f2) throws IOException {
        return Float.valueOf(JsonUtils.g(jsonReader) * f2);
    }
}
