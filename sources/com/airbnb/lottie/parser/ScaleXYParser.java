package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

public class ScaleXYParser implements ValueParser<ScaleXY> {

    /* renamed from: a  reason: collision with root package name */
    public static final ScaleXYParser f17318a = new ScaleXYParser();

    private ScaleXYParser() {
    }

    /* renamed from: b */
    public ScaleXY a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.s() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        float k2 = (float) jsonReader.k();
        float k3 = (float) jsonReader.k();
        while (jsonReader.h()) {
            jsonReader.w();
        }
        if (z) {
            jsonReader.e();
        }
        return new ScaleXY((k2 / 100.0f) * f2, (k3 / 100.0f) * f2);
    }
}
