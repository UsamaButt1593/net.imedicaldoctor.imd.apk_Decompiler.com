package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class FontParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f17289a = JsonReader.Options.a("fFamily", "fName", "fStyle", "ascent");

    private FontParser() {
    }

    static Font a(JsonReader jsonReader) throws IOException {
        jsonReader.d();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f2 = 0.0f;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17289a);
            if (u == 0) {
                str = jsonReader.q();
            } else if (u == 1) {
                str2 = jsonReader.q();
            } else if (u == 2) {
                str3 = jsonReader.q();
            } else if (u != 3) {
                jsonReader.v();
                jsonReader.w();
            } else {
                f2 = (float) jsonReader.k();
            }
        }
        jsonReader.f();
        return new Font(str, str2, str3, f2);
    }
}
