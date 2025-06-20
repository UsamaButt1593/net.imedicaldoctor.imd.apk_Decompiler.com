package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

class FontCharacterParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f17287a = JsonReader.Options.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f17288b = JsonReader.Options.a("shapes");

    private FontCharacterParser() {
    }

    static FontCharacter a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.d();
        double d2 = 0.0d;
        String str = null;
        String str2 = null;
        double d3 = 0.0d;
        char c2 = 0;
        while (jsonReader.h()) {
            int u = jsonReader.u(f17287a);
            if (u == 0) {
                c2 = jsonReader.q().charAt(0);
            } else if (u == 1) {
                d3 = jsonReader.k();
            } else if (u == 2) {
                d2 = jsonReader.k();
            } else if (u == 3) {
                str = jsonReader.q();
            } else if (u == 4) {
                str2 = jsonReader.q();
            } else if (u != 5) {
                jsonReader.v();
                jsonReader.w();
            } else {
                jsonReader.d();
                while (jsonReader.h()) {
                    if (jsonReader.u(f17288b) != 0) {
                        jsonReader.v();
                        jsonReader.w();
                    } else {
                        jsonReader.c();
                        while (jsonReader.h()) {
                            arrayList.add((ShapeGroup) ContentModelParser.a(jsonReader, lottieComposition));
                        }
                        jsonReader.e();
                    }
                }
                jsonReader.f();
            }
        }
        jsonReader.f();
        return new FontCharacter(arrayList, c2, d3, d2, str, str2);
    }
}
