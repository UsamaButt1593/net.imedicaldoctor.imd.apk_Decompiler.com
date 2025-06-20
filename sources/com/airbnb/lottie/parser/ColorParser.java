package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class ColorParser implements ValueParser<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final ColorParser f17282a = new ColorParser();

    private ColorParser() {
    }

    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.s() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.c();
        }
        double k2 = jsonReader.k();
        double k3 = jsonReader.k();
        double k4 = jsonReader.k();
        double k5 = jsonReader.k();
        if (z) {
            jsonReader.e();
        }
        if (k2 <= 1.0d && k3 <= 1.0d && k4 <= 1.0d) {
            k2 *= 255.0d;
            k3 *= 255.0d;
            k4 *= 255.0d;
            if (k5 <= 1.0d) {
                k5 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) k5, (int) k2, (int) k3, (int) k4));
    }
}
